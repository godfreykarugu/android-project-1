//package net.ezra.ui.cars
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material3.CenterAlignedTopAppBar
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import coil.compose.rememberAsyncImagePainter
//import net.ezra.navigation.ROUTE_VIEW_CARS
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CarDetailScreen(navController: NavController, carId: String) {
//
//    var car by remember { mutableStateOf<Car?>(null) }
//
//    LaunchedEffect(Unit) {
//        fetchCar(carId) { fetchedCar ->
//            car = fetchedCar
//        }
//    }
//
//
//
//
////    LaunchedEffect(Unit) {
////        fetchCars(carId) { fetchedCar ->
////            car = fetchedCar as Car?
////        }
////    }
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    // Display the car name if available
//                    Text(
//                        text = car?.name ?:"Details",
//                        fontSize = 20.sp,
//                        color = Color.White
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        navController.navigate(ROUTE_VIEW_CARS)
//                    }) {
//                        Icon(
//                            Icons.AutoMirrored.Filled.ArrowBack,
//                            "backIcon",
//                            tint = Color.White
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xff0FB06A),
//                    titleContentColor = Color.White,
//                )
//            )
//        },
//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xff9AEDC9)),
//            ) {
//                car?.let {
//                    Column(
//                        modifier = Modifier.padding(16.dp)
//                    ) {
//                        Image(
//                            painter = rememberAsyncImagePainter(it.imageUrl),
//                            contentDescription = null,
//                            modifier = Modifier.size(60.dp)
//                        )
//                        Text(text = it.name,)
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Text(text = "Price: ${it.charge}")
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Text(text = it.model)
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Text(text = it.registration)
//
//                    }
//                }
//            }
//        }
//    )
//
//}
//


//-----------------------------version 2
//
//package net.ezra.ui.cars
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import coil.compose.rememberAsyncImagePainter
//import net.ezra.navigation.ROUTE_VIEW_CARS
//import kotlinx.coroutines.tasks.await
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.firestore.ktx.toObject
//import com.google.firebase.ktx.Firebase
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CarDetailScreen(navController: NavController, carId: String) {
//    var car by remember { mutableStateOf<Car?>(null) }
//
//    LaunchedEffect(carId) {
//        fetchCar(carId) { fetchedCar ->
//            car = fetchedCar
//        }
//    }
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text(
//                        text = car?.name ?: "Details",
//                        fontSize = 20.sp,
//                        color = Color.White
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        navController.navigate(ROUTE_VIEW_CARS)
//                    }) {
//                        Icon(
//                            Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Back",
//                            tint = Color.White
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xff0FB06A),
//                    titleContentColor = Color.White,
//                )
//            )
//        },
//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xff9AEDC9))
//                    .padding(16.dp),
//            ) {
//                car?.let {
//                    Column {
//                        Image(
//                            painter = rememberAsyncImagePainter(it.imageUrl),
//                            contentDescription = null,
//                            modifier = Modifier.size(200.dp) // Increased size for better visibility
//                        )
//                        Spacer(modifier = Modifier.height(16.dp))
//                        Text(text = it.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Text(text = "Price: ${it.charge}", fontSize = 18.sp)
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Text(text = "Model: ${it.model}", fontSize = 18.sp)
//                        Spacer(modifier = Modifier.height(8.dp))
//                        Text(text = "Registration: ${it.registration}", fontSize = 18.sp)
//                    }
//                } ?: run {
//                    Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        CircularProgressIndicator()
//                    }
//                }
//            }
//        }
//    )
//}
//
//@Suppress("DEPRECATION")
//private suspend fun fetchCar(carId: String, onSuccess: (Car?) -> Unit) {
//    val firestore = Firebase.firestore
//    try {
//        val docRef = firestore.collection("cars").document(carId)
//        val snapshot = docRef.get().await()
//        val car = snapshot.toObject<Car>()
//        onSuccess(car)
//    } catch (e: Exception) {
//        onSuccess(null)
//    }
//}



//-------------------------- Version -3----------------------------------------------------------


//package net.ezra.ui.cars
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import coil.compose.rememberAsyncImagePainter
//import net.ezra.navigation.ROUTE_VIEW_CARS
//import kotlinx.coroutines.launch
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.firestore.ktx.toObject
//import com.google.firebase.ktx.Firebase
//import kotlinx.coroutines.tasks.await
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CarDetailScreen(navController: NavController, carId: String) {
//    var car by remember { mutableStateOf<Car?>(null) }
//    val scope = rememberCoroutineScope()
//    var isEditing by remember { mutableStateOf(false) }
//
//    LaunchedEffect(carId) {
//        fetchCar(carId) { fetchedCar ->
//            car = fetchedCar
//        }
//    }
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text(
//                        text = car?.name ?: "Details",
//                        fontSize = 20.sp,
//                        color = Color.White
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        navController.navigate(ROUTE_VIEW_CARS)
//                    }) {
//                        Icon(
//                            Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Back",
//                            tint = Color.White
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xff0FB06A),
//                    titleContentColor = Color.White,
//                )
//            )
//        },
//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xff9AEDC9))
//                    .padding(16.dp),
//            ) {
//                car?.let {
//                    if (isEditing) {
//                        CarEditForm(car = it, onSave = { updatedCar ->
//                            scope.launch {
//                                updateCar(updatedCar)
//                                isEditing = false
//                            }
//                        }, onCancel = {
//                            isEditing = false
//                        })
//                    } else {
//                        CarDetailContent(car = it, onEdit = { isEditing = true })
//                    }
//                } ?: run {
//                    Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        CircularProgressIndicator()
//                    }
//                }
//            }
//        }
//    )
//}
//
//@Composable
//fun CarDetailContent(car: Car, onEdit: () -> Unit) {
//    Column {
//        Image(
//            painter = rememberAsyncImagePainter(car.imageUrl),
//            contentDescription = null,
//            modifier = Modifier.size(200.dp)
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(text = car.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = "Price: ${car.charge}", fontSize = 18.sp)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = "Model: ${car.model}", fontSize = 18.sp)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = "Registration: ${car.registration}", fontSize = 18.sp)
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = onEdit) {
//            Text("Edit")
//        }
//    }
//}
//
//@Composable
//fun CarEditForm(car: Car, onSave: (Car) -> Unit, onCancel: () -> Unit) {
//    var name by remember { mutableStateOf(car.name) }
//    var charge by remember { mutableStateOf(car.charge.toString()) }
//    var model by remember { mutableStateOf(car.model) }
//    var registration by remember { mutableStateOf(car.registration) }
//    var imageUrl by remember { mutableStateOf(car.imageUrl) }
//
//    Column {
//        OutlinedTextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text("Name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = charge,
//            onValueChange = { charge = it },
//            label = { Text("Price") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = model,
//            onValueChange = { model = it },
//            label = { Text("Model") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = registration,
//            onValueChange = { registration = it },
//            label = { Text("Registration") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = imageUrl,
//            onValueChange = { imageUrl = it },
//            label = { Text("Image URL") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Row {
//            Button(onClick = {
//                val updatedCar = car.copy(
//                    name = name,
//                    charge = charge.toDoubleOrNull() ?: car.charge,
//                    model = model,
//                    registration = registration,
//                    imageUrl = imageUrl
//                )
//                onSave(updatedCar)
//            }) {
//                Text("Save")
//            }
//            Spacer(modifier = Modifier.width(8.dp))
//            Button(onClick = onCancel) {
//                Text("Cancel")
//            }
//        }
//    }
//}
//
//@Suppress("DEPRECATION")
//private suspend fun fetchCar(carId: String, onSuccess: (Car?) -> Unit) {
//    val firestore = Firebase.firestore
//    try {
//        val docRef = firestore.collection("cars").document(carId)
//        val snapshot = docRef.get().await()
//        val car = snapshot.toObject<Car>()
//        onSuccess(car)
//    } catch (e: Exception) {
//        onSuccess(null)
//    }
//}
//
//@Suppress("DEPRECATION")
//private suspend fun updateCar(car: Car) {
//    val firestore = Firebase.firestore
//    try {
//        firestore.collection("cars").document(car.id).set(car).await()
//    } catch (e: Exception) {
//        // Handle the error, e.g., show a toast or a message
//    }
//}


// --------------- Version -4-- imporoved update functonality-------------------------------------------------------------------------------


//package net.ezra.ui.cars
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import coil.compose.rememberAsyncImagePainter
//import net.ezra.navigation.ROUTE_VIEW_CARS
//import kotlinx.coroutines.launch
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.firestore.ktx.toObject
//import com.google.firebase.ktx.Firebase
//import kotlinx.coroutines.tasks.await
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CarDetailScreen(navController: NavController, carId: String) {
//    var car by remember { mutableStateOf<Car?>(null) }
//    val scope = rememberCoroutineScope()
//    var isEditing by remember { mutableStateOf(false) }
//
//    LaunchedEffect(carId) {
//        fetchCar(carId) { fetchedCar ->
//            car = fetchedCar
//        }
//    }
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text(
//                        text = car?.name ?: "Details",
//                        fontSize = 20.sp,
//                        color = Color.White
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        navController.navigate(ROUTE_VIEW_CARS)
//                    }) {
//                        Icon(
//                            Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Back",
//                            tint = Color.White
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xff0FB06A),
//                    titleContentColor = Color.White,
//                )
//            )
//        },
//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xff9AEDC9))
//                    .padding(16.dp),
//            ) {
//                car?.let {
//                    if (isEditing) {
//                        CarEditForm(car = it, onSave = { updatedCar ->
//                            scope.launch {
//                                updateCar(updatedCar)
//                                isEditing = false
//                                // Refetch car to update the UI with the latest data
//                                fetchCar(carId) { fetchedCar ->
//                                    car = fetchedCar
//                                }
//                            }
//                        }, onCancel = {
//                            isEditing = false
//                        })
//                    } else {
//                        CarDetailContent(car = it, onEdit = { isEditing = true })
//                    }
//                } ?: run {
//                    Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        CircularProgressIndicator()
//                    }
//                }
//            }
//        }
//    )
//}
//
//@Composable
//fun CarDetailContent(car: Car, onEdit: () -> Unit) {
//    Column {
//        Image(
//            painter = rememberAsyncImagePainter(car.imageUrl),
//            contentDescription = null,
//            modifier = Modifier.size(200.dp)
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(text = car.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = "Price: ${car.charge}", fontSize = 18.sp)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = "Model: ${car.model}", fontSize = 18.sp)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = "Registration: ${car.registration}", fontSize = 18.sp)
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = onEdit) {
//            Text("Edit")
//        }
//    }
//}
//
//@Composable
//fun CarEditForm(car: Car, onSave: (Car) -> Unit, onCancel: () -> Unit) {
//    var name by remember { mutableStateOf(car.name) }
//    var charge by remember { mutableStateOf(car.charge.toString()) }
//    var model by remember { mutableStateOf(car.model) }
//    var registration by remember { mutableStateOf(car.registration) }
//    var imageUrl by remember { mutableStateOf(car.imageUrl) }
//
//    Column {
//        OutlinedTextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text("Name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = charge,
//            onValueChange = { charge = it },
//            label = { Text("Price") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = model,
//            onValueChange = { model = it },
//            label = { Text("Model") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = registration,
//            onValueChange = { registration = it },
//            label = { Text("Registration") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        OutlinedTextField(
//            value = imageUrl,
//            onValueChange = { imageUrl = it },
//            label = { Text("Image URL") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Row {
//            Button(onClick = {
//                val updatedCar = car.copy(
//                    name = name,
//                    charge = charge.toDoubleOrNull() ?: car.charge,
//                    model = model,
//                    registration = registration,
//                    imageUrl = imageUrl
//                )
//                onSave(updatedCar)
//            }) {
//                Text("Save")
//            }
//            Spacer(modifier = Modifier.width(8.dp))
//            Button(onClick = onCancel) {
//                Text("Cancel")
//            }
//        }
//    }
//}
//
//@Suppress("DEPRECATION")
//private suspend fun fetchCar(carId: String, onSuccess: (Car?) -> Unit) {
//    val firestore = Firebase.firestore
//    try {
//        val docRef = firestore.collection("cars").document(carId)
//        val snapshot = docRef.get().await()
//        val car = snapshot.toObject<Car>()
//        onSuccess(car)
//    } catch (e: Exception) {
//        onSuccess(null)
//    }
//}
//
//@Suppress("DEPRECATION")
//private suspend fun updateCar(car: Car) {
//    val firestore = Firebase.firestore
//    try {
//        firestore.collection("cars").document(car.id).set(car).await()
//    } catch (e: Exception) {
//        // Handle the error, e.g., show a toast or a message
//    }
//}


//---------version-5  adding delete functionality


package net.ezra.ui.cars

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import net.ezra.navigation.ROUTE_VIEW_CARS
import kotlinx.coroutines.launch
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarDetailScreen(navController: NavController, carId: String) {
    var car by remember { mutableStateOf<Car?>(null) }
    val scope = rememberCoroutineScope()
    var isEditing by remember { mutableStateOf(false) }

    LaunchedEffect(carId) {
        fetchCar(carId) { fetchedCar ->
            car = fetchedCar
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = car?.name ?: "Details",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_VIEW_CARS)
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff0FB06A),
                    titleContentColor = Color.White,
                )
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff9AEDC9))
                    .padding(16.dp),
            ) {
                car?.let {
                    if (isEditing) {
                        CarEditForm(car = it, onSave = { updatedCar ->
                            scope.launch {
                                updateCar(updatedCar)
                                isEditing = false
                                // Refetch car to update the UI with the latest data
                                fetchCar(carId) { fetchedCar ->
                                    car = fetchedCar
                                }
                            }
                        }, onCancel = {
                            isEditing = false
                        })
                    } else {
                        CarDetailContent(car = it, onEdit = { isEditing = true }, onDelete = {
                            scope.launch {
                                deleteCar(car!!.id)
                                navController.navigate(ROUTE_VIEW_CARS)
                            }
                        })
                    }
                } ?: run {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    )
}

@Composable
fun CarDetailContent(car: Car, onEdit: () -> Unit, onDelete: () -> Unit) {
    Column {
        Image(
            painter = rememberAsyncImagePainter(car.imageUrl),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = car.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Price: ${car.charge}", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Model: ${car.model}", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Registration: ${car.registration}", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = onEdit) {
                Text("Edit")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = onDelete, colors = ButtonDefaults.buttonColors(Color.Red)) {
                Text("Delete")
            }
        }
    }
}

@Composable
fun CarEditForm(car: Car, onSave: (Car) -> Unit, onCancel: () -> Unit) {
    var name by remember { mutableStateOf(car.name) }
    var charge by remember { mutableStateOf(car.charge.toString()) }
    var model by remember { mutableStateOf(car.model) }
    var registration by remember { mutableStateOf(car.registration) }
    var imageUrl by remember { mutableStateOf(car.imageUrl) }

    Column {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = charge,
            onValueChange = { charge = it },
            label = { Text("Price") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = model,
            onValueChange = { model = it },
            label = { Text("Model") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = registration,
            onValueChange = { registration = it },
            label = { Text("Registration") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = imageUrl,
            onValueChange = { imageUrl = it },
            label = { Text("Image URL") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = {
                val updatedCar = car.copy(
                    name = name,
                    charge = charge.toDoubleOrNull() ?: car.charge,
                    model = model,
                    registration = registration,
                    imageUrl = imageUrl
                )
                onSave(updatedCar)
            }) {
                Text("Save")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = onCancel) {
                Text("Cancel")
            }
        }
    }
}

@Suppress("DEPRECATION")
private suspend fun fetchCar(carId: String, onSuccess: (Car?) -> Unit) {
    val firestore = Firebase.firestore
    try {
        val docRef = firestore.collection("cars").document(carId)
        val snapshot = docRef.get().await()
        val car = snapshot.toObject<Car>()
        onSuccess(car)
    } catch (e: Exception) {
        onSuccess(null)
    }
}

@Suppress("DEPRECATION")
private suspend fun updateCar(car: Car) {
    val firestore = Firebase.firestore
    try {
        firestore.collection("cars").document(car.id).set(car).await()
    } catch (e: Exception) {
        // Handle the error, e.g., show a toast or a message
    }
}

@Suppress("DEPRECATION")
private suspend fun deleteCar(carId: String) {
    val firestore = Firebase.firestore
    try {
        firestore.collection("cars").document(carId).delete().await()
    } catch (e: Exception) {
        // Handle the error, e.g., show a toast or a message
    }
}
