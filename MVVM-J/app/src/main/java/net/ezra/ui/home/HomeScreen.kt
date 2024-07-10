//package net.ezra.ui.home
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.layout.wrapContentHeight
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.CenterAlignedTopAppBar
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.scale
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import net.ezra.R
//import net.ezra.navigation.ROUTE_ABOUT
//import net.ezra.navigation.ROUTE_CONTACT
//import net.ezra.navigation.ROUTE_DASHBOARD
//import net.ezra.navigation.ROUTE_INSERT_CARS
//import net.ezra.navigation.ROUTE_INSERT_PRODUCT
//import net.ezra.navigation.ROUTE_LOGIN
//import net.ezra.navigation.ROUTE_REGISTER
//import net.ezra.navigation.ROUTE_SHOP
//import net.ezra.navigation.ROUTE_VIEW_CARS
//import net.ezra.navigation.ROUTE_VIEW_PRODUCTS
//
//@Composable
//fun HomeScreen(navController: NavHostController) {
//
//
//
//
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .padding(10.dp)
//            .padding(top = 10.dp)
//            .background(Color(0xFFCFAE32))
//
//    ){
//        Text(text = "Dave Tours, Service Per Excellence"
//            , modifier = Modifier.padding(10.dp),
//            style = MaterialTheme.typography.headlineLarge,
//            color = Color.Black,
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            )
//
//
//        Image(painter = painterResource(id = R.drawable.bimg),
//            contentDescription = "Logo",
////            modifier = Modifier.scale(scale.value)
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp),
//            contentScale = ContentScale.Crop
//        )
//
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//
//
//       Row (
//           modifier = Modifier.fillMaxWidth(),
//           horizontalArrangement = Arrangement.SpaceEvenly
//       ){
//
//
//
//
//       }
//
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Row (
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ){
//
//            //-----------------insert a card--------------------
//
//            Card(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(16.dp),
//                colors = CardDefaults.cardColors(containerColor = Color.White),
//                elevation = CardDefaults.cardElevation(8.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//
//                    Image(painter = painterResource(id = R.drawable.img10),
//                        contentDescription = "Logo",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .width(50.dp)
//                            .height(80.dp),
//                        contentScale = ContentScale.Crop
//                    )
//
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Button(onClick = {
//                        navController.navigate(ROUTE_INSERT_CARS)
//                    }) {
//
//                        Text(text = "Insert Car")
//
//                    }
//                }
//            }
//
//            //----------------end of the card--------------------
//
//
//            //-----------------insert a card--------------------
//
//            Card(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(16.dp),
//                colors = CardDefaults.cardColors(containerColor = Color.White),
//                elevation = CardDefaults.cardElevation(8.dp),
//                shape = RoundedCornerShape(16.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//
//
//                    Image(painter = painterResource(id = R.drawable.img11),
//                        contentDescription = "Logo",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .width(50.dp)
//                            .height(80.dp),
//                        contentScale = ContentScale.Crop
//                    )
//
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Button(onClick = {
//                        navController.navigate(ROUTE_VIEW_CARS)
//                    }) {
//
//                        Text(text = "View Car")
//
//                    }
//                }
//            }
//
//            //----------------end of the card--------------------
//
//
//        }
//
//        Row (
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ){
//
//            //-----------------insert a card--------------------
//
//            Card(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(16.dp),
//                colors = CardDefaults.cardColors(containerColor = Color.White),
//                elevation = CardDefaults.cardElevation(8.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
////                    Text(text = "Card Title", style = MaterialTheme.typography.titleLarge)
//                    Image(painter = painterResource(id = R.drawable.create),
//                        contentDescription = "Logo",
////            modifier = Modifier.scale(scale.value)
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .width(50.dp)
//                            .height(80.dp),
//                        contentScale = ContentScale.Crop
//                    )
//
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Button(onClick = {
//                        navController.navigate(ROUTE_INSERT_CARS)
//                    }) {
//
//                        Text(text = "Insert Car")
//
//                    }
//                }
//            }
//
//            //----------------end of the card--------------------
//
//
//            //-----------------insert a card--------------------
//
//            Card(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(16.dp),
//                colors = CardDefaults.cardColors(containerColor = Color.White),
//                elevation = CardDefaults.cardElevation(8.dp),
//                shape = RoundedCornerShape(16.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//
//
//                    Image(painter = painterResource(id = R.drawable.create),
//                        contentDescription = "Logo",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .width(50.dp)
//                            .height(80.dp),
//                        contentScale = ContentScale.Crop
//                    )
//
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Button(onClick = {
//                        navController.navigate(ROUTE_VIEW_CARS)
//                    }) {
//
//                        Text(text = "View Car")
//
//                    }
//                }
//            }
//
//
//
//        }
//
//
//
//    }
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewLight() {
//    HomeScreen(rememberNavController())
//}
//




package net.ezra.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_INSERT_CARS
import net.ezra.navigation.ROUTE_VIEW_CARS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Dave Tours, Service Per Excellence",
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFCFAE32),
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
                    onClick = { navController.navigate(ROUTE_VIEW_CARS) }

                )

                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Cars") },
                    label = { Text("Cars") },
                    selected = true,
                    onClick = { navController.navigate(ROUTE_INSERT_CARS) }

                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp)
                .padding(top = 10.dp)
                .background(Color(0xFFCFAE32))
        ) {
//            Text(
//                text = "Dave Tours, Service Per Excellence",
//                modifier = Modifier.padding(10.dp),
//                style = MaterialTheme.typography.headlineLarge,
//                color = Color.Black,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp,
//            )

            Image(
                painter = painterResource(id = R.drawable.bimg),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Add content here if needed
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(8.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img10),
                            contentDescription = "Insert Car",
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(50.dp)
                                .height(80.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            navController.navigate(ROUTE_INSERT_CARS)
                        }) {
                            Text(text = "Insert Car")
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(8.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img11),
                            contentDescription = "View Car",
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(50.dp)
                                .height(80.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            navController.navigate(ROUTE_VIEW_CARS)
                        }) {
                            Text(text = "View Car")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HomeScreen(rememberNavController())
}
