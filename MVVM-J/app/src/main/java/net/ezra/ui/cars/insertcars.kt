package net.ezra.ui.cars

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import net.ezra.navigation.ROUTE_VIEW_CARS
import net.ezra.navigation.ROUTE_VIEW_PRODUCTS
import net.ezra.ui.products.addProductToFirestore
import net.ezra.ui.cars.uploadImageToStorage
import java.util.UUID

@Composable
fun InsertCarScreen(navController: NavController,onInsertCar:()->Unit) {
    var contactName by remember { mutableStateOf("") }
    var carModel by remember { mutableStateOf("") }
    var chargePerDay by remember { mutableStateOf("") }
    var regNumber by remember { mutableStateOf("") }
    var carImageUri by remember { mutableStateOf<Uri?>(null) }

    var contactNameError by remember { mutableStateOf(false) }
    var carModelError by remember { mutableStateOf(false) }
    var chargePerDayError by remember { mutableStateOf(false) }
    var regNumberError by remember { mutableStateOf(false) }
    var carImageError by remember { mutableStateOf(false) }

    var isUploading by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            carImageUri = it
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
//            .background(Color(0xff9AEDC9))
            .background(Color(0xFFCFAE32))
            .padding(10.dp)
    ){

        item {


            if (carImageUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(carImageUri),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No Image Selected", modifier = Modifier.padding(8.dp))
                }
            }



            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { launcher.launch("image/*") }
            ) {
                Text("Select Image")
            }
            Spacer(modifier = Modifier.height(16.dp))


            TextField(
                value = contactName,
                onValueChange = { contactName = it },
                label = { Text("Owner's Name") },
                isError = contactNameError,
                modifier = Modifier.fillMaxWidth()
            )


            TextField(
                value = carModel,
                onValueChange = { carModel = it },
                label = { Text("Enter Car Model") },
                isError = carModelError,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))


            TextField(
                value = regNumber,
                onValueChange = { regNumber = it },
                label = { Text("Enter Registration Number") },
                isError = regNumberError,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))


            TextField(
                value = chargePerDay,
                onValueChange = { chargePerDay = it },
                label = { Text("Enter Charge Per Day") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = chargePerDayError,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(16.dp))

            if (contactNameError) {
                Text("Owner's Name is required", color = Color.Red)
            }
            if (carModelError) {
                Text("Car's Model is required", color = Color.Red)
            }
            if (chargePerDayError) {
                Text("Cost per Day is required", color = Color.Red)
            }
            if (carImageError) {
                Text("Product Image is required", color = Color.Red)
            }
            if (regNumberError) {
                Text("Registration Number is required", color = Color.Red)
            }



            if (!isUploading) {
                Button(
                    onClick = {
                        contactNameError = contactName.isBlank()
                        carModelError = carModel.isBlank()
                        chargePerDayError = chargePerDay.isBlank()
                        regNumberError = regNumber.isBlank()
                        carImageError = carImageUri == null

                        if (!contactNameError && !carModelError && !chargePerDayError && !carImageError && !regNumberError) {
                            isUploading = true
//
//                            addProductToFirestore
                            insertCarToFirestore(
                                navController,
                                onInsertCar,
                                contactName,
                                carModel,
                                regNumber,
                                chargePerDay.toDouble(),
                                carImageUri,
                                onUploadComplete = { isUploading = false }
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Upload Car")
                }
            }

            if (isUploading) {
                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                    Text("Uploading...", modifier = Modifier.padding(start = 8.dp))
                }
            }



        }
    }


}

fun insertCarToFirestore(
    navController: NavController,
    onInsertCar: () -> Unit,
    contactName: String,
    carModel: String,
    regNumber: String,
    chargePerDay: Double,
    carImageUri: Uri?,
    onUploadComplete: () -> Unit


) {

    if (carImageUri == null) return

    val carId = UUID.randomUUID().toString()
    val firestore = Firebase.firestore
    val carData = hashMapOf(
        "name" to contactName,
        "model" to carModel,
        "charge" to chargePerDay,
        "registration" to regNumber,
        "imageUrl" to ""
    )

    firestore.collection("cars").document(carId)
        .set(carData)
        .addOnSuccessListener {
            uploadImageToStorage(carId, carImageUri) { imageUrl ->
                firestore.collection("cars").document(carId)
                    .update("imageUrl", imageUrl)
                    .addOnSuccessListener {
                        Toast.makeText(navController.context, "Car added successfully!", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_VIEW_CARS)
                        onInsertCar()
                        onUploadComplete()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(navController.context, "Failed to update car image URL.", Toast.LENGTH_SHORT).show()
                        onUploadComplete()
                    }
            }
        }
        .addOnFailureListener { e ->
            Toast.makeText(navController.context, "Failed to add car.", Toast.LENGTH_SHORT).show()
            onUploadComplete()
        }

}


private fun uploadImageToStorage(carId: String, imageUri: Uri?, onSuccess: (String) -> Unit) {
    if (imageUri == null) {
        onSuccess("")
        return
    }

    val storageRef = Firebase.storage.reference
    val imagesRef = storageRef.child("cars/$carId.jpg")

    imagesRef.putFile(imageUri)
        .addOnSuccessListener {
            imagesRef.downloadUrl
                .addOnSuccessListener { uri ->
                    onSuccess(uri.toString())
                }
                .addOnFailureListener {
                    onSuccess("")
                }
        }
        .addOnFailureListener {
            onSuccess("")
        }

}
