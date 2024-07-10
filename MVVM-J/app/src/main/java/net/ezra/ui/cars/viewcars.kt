//package net.ezra.ui.cars
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.BottomNavigationItem
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.Card
//import androidx.compose.material.CircularProgressIndicator
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Person
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
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import coil.compose.rememberAsyncImagePainter
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.firestore.ktx.toObject
//import com.google.firebase.ktx.Firebase
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.tasks.await
//import net.ezra.navigation.ROUTE_HOME
//import net.ezra.ui.products.Product
//import net.ezra.ui.products.ProductListItem
//import java.time.format.TextStyle
//
////import net.ezra.ui.cars.fetchCars
//
//data class Car(
//    var id: String = "",
//    val name: String = "",
//    val registration: String = "",
//    val model: String ="",
//    val charge: Double = 0.0,
//    var imageUrl: String = ""
//)
//
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//
//
//fun CarListScreen(navController: NavController, cars: List<Car>) {
//    var isLoading by remember { mutableStateOf(true) }
//    var carList by remember { mutableStateOf(emptyList<Car>()) }
//    var displayedCarCount by remember { mutableStateOf(6) }
//    var progress by remember { mutableStateOf(0) }
//
//    LaunchedEffect(Unit) {
//        fetchCars(
//            onSuccess = { fetchedCars ->
//                carList = fetchedCars
//                isLoading = false
//            },
//
//
//            onError = {
//                isLoading = false
//                // Handle the error, e.g., show a toast or a message
//            }
//        )
//
//        // Simulate progress for loading state
//        while (isLoading) {
//            delay(100)
//            progress = (progress + 1) % 101
//        }
//    }
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text(
//                    text = "Dave-Tours Collection",
//                           fontSize = 20.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = Color.White
//                ) },
//                navigationIcon = {
//                    IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
//                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xFF8110A8),
//                    titleContentColor = Color.White,
//                )
//            )
//        },
//
//        bottomBar = {
//            BottomNavigation {
//                BottomNavigationItem(
//                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
//                    label = { Text("Home") },
//                    selected = false,
//                    onClick = { navController.navigate(ROUTE_HOME) }
//                )
//                BottomNavigationItem(
//                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Cars") },
//                    label = { Text("Cars") },
//                    selected = true,
//                    onClick = { /* Current screen, no navigation */ }
//                )
//
//                BottomNavigationItem(
//                    icon = { Icon(Icons.Default.Person, contentDescription = "Cars") },
//                    label = { Text("Cars") },
//                    selected = true,
//                    onClick = { /* Current screen, no navigation */ }
//                )
//                // Add more BottomNavigationItem as needed
//            }
//        }
//    )
//
//    {
//        Column(
////            contentPadding = innerPadding,
//            modifier = Modifier
//                .fillMaxSize()
////                .background(Color(0xFFCC923D))
//                .background(Color(0xFFCFAE32))
//        ) {
//            if (isLoading) {
//                // Progress indicator
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    CircularProgressIndicator(progress = progress / 100f)
//                    Text(text = "Loading... $progress%", fontSize = 20.sp)
//                }
//            } else {
//                if (carList.isEmpty()) {
//                    // No car found
//                    Text(text = "No Car found", modifier = Modifier.align(Alignment.CenterHorizontally))
//                } else {
//                    // car list
//                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
//                        items(carList.take(displayedCarCount)) { car ->
//                            CarListItem(car) {
//                                navController.navigate("carDetails/${car.id}")
//                            }
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(16.dp))
//                    // Load More Button
//                    if (displayedCarCount < carList.size) {
//                        Button(
//                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff0FB06A)),
//                            onClick = { displayedCarCount += 1 },
//                            modifier = Modifier.align(Alignment.CenterHorizontally)
//                        ) {
//                            Text(text = "Load More")
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//
//
//}
//
//
//    @Composable
//    fun CarListItem(car: Car, onItemClick: (String) -> Unit) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//                .clickable { onItemClick(car.id) }
//        ) {
//
//
//                  Row(
//                      verticalAlignment = Alignment.CenterVertically,
//                      modifier = Modifier.padding(16.dp)
//                  ) {
//                      // Product Image
//                      Image(
//                          painter = rememberAsyncImagePainter(car.imageUrl),
//                          contentDescription = null,
//                          modifier = Modifier
//                              .size(60.dp)
//                      )
//
//                      Spacer(modifier = Modifier.width(16.dp))
//
//                      // Product Details
//                      Column {
//                          Text(text = car.name)
//                          Text(text = car.model)
//                          Text(text = car.registration)
//                          Text(text = "Charge: ${car.charge}")
//                      }
//
//                  }
//
//
//        }
//    }
//
//
//
//
//    @Suppress("DEPRECATION")
//    private suspend fun fetchCars(onSuccess: (List<Car>) -> Unit, onError: () -> Unit) {
//        val firestore = Firebase.firestore
//        try {
//            val snapshot = firestore.collection("cars").get().await()
//            val carList = snapshot.documents.mapNotNull { doc ->
//                val car = doc.toObject<Car>()
//                car?.id = doc.id
//                car
//            }
//            onSuccess(carList)
//        } catch (e: Exception) {
//            onError()
//        }
//    }
//
//
//
//    suspend fun fetchCars(carId: String, onSuccess: (Car?) -> Unit) {
//        val firestore = Firebase.firestore
//        val docRef = firestore.collection("cars").document(carId)
//        val snapshot = docRef.get().await()
//        val car = snapshot.toObject<Car>()
//        onSuccess(car)
//    }
//
//
//
//
//


package net.ezra.ui.cars

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import net.ezra.navigation.ROUTE_HOME

data class Car(
    var id: String = "",
    val name: String = "",
    val registration: String = "",
    val model: String = "",
    val charge: Double = 0.0,
    var imageUrl: String = ""
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarListScreen(navController: NavController, cars: List<Car>) {
    var isLoading by remember { mutableStateOf(true) }
    var carList by remember { mutableStateOf(emptyList<Car>()) }
    var displayedCarCount by remember { mutableStateOf(6) }
    var progress by remember { mutableStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        fetchCars(
            onSuccess = { fetchedCars ->
                carList = fetchedCars
                isLoading = false
            },
            onError = {
                isLoading = false
                // Handle the error, e.g., show a toast or a message
            }
        )

        // Simulate progress for loading state
        while (isLoading) {
            delay(100)
            progress = (progress + 1) % 101
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Dave-Tours Collection",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF8110A8),
                    titleContentColor = Color.White,
                )
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { navController.navigate(ROUTE_HOME) }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Cars") },
                    label = { Text("Cars") },
                    selected = true,
                    onClick = { /* Current screen, no navigation */ }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = { /* Navigate to profile screen */ }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCFAE32))
                .padding(it)
        ) {
            if (isLoading) {
                // Progress indicator
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(progress = progress / 100f)
                    Text(text = "Loading... $progress%", fontSize = 20.sp)
                }
            } else {
                Column {
                    // Search bar
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        label = { Text("Search Cars") },
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )

                    val filteredCars = carList.filter { car ->
                        car.name.contains(searchQuery, ignoreCase = true) ||
                                car.model.contains(searchQuery, ignoreCase = true) ||
                                car.registration.contains(searchQuery, ignoreCase = true)
                    }

                    if (filteredCars.isEmpty()) {
                        // No car found
                        Text(
                            text = "No Car found",
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    } else {
                        // car list
                        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                            items(filteredCars.take(displayedCarCount)) { car ->
                                CarListItem(car) {
                                    navController.navigate("carDetails/${car.id}")
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        // Load More Button
                        if (displayedCarCount < filteredCars.size) {
                            Button(
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff0FB06A)),
                                onClick = { displayedCarCount += 1 },
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            ) {
                                Text(text = "Load More")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CarListItem(car: Car, onItemClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick(car.id) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            // Car Image
            Image(
                painter = rememberAsyncImagePainter(car.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Car Details
            Column {
                Text(text = car.name)
                Text(text = car.model)
                Text(text = car.registration)
                Text(text = "Charge: ${car.charge}")
            }
        }
    }
}

@Suppress("DEPRECATION")
private suspend fun fetchCars(onSuccess: (List<Car>) -> Unit, onError: () -> Unit) {
    val firestore = Firebase.firestore
    try {
        val snapshot = firestore.collection("cars").get().await()
        val carList = snapshot.documents.mapNotNull { doc ->
            val car = doc.toObject<Car>()
            car?.id = doc.id
            car
        }
        onSuccess(carList)
    } catch (e: Exception) {
        onError()
    }
}

suspend fun fetchCarById(carId: String, onSuccess: (Car?) -> Unit) {
    val firestore = Firebase.firestore
    val docRef = firestore.collection("cars").document(carId)
    val snapshot = docRef.get().await()
    val car = snapshot.toObject<Car>()
    onSuccess(car)
}


