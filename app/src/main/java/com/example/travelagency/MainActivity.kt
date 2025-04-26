package com.example.travelagency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.travelagency.core.ui.Drawer
import com.example.travelagency.createTrip.ui.AppDrawerContent
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {

                val navController = rememberNavController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                Drawer(
                    drawerState = drawerState, // Pass the hoisted drawerState
                    navigateTo = { route ->
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(route)
                    },
                    drawerContent = {
                        AppDrawerContent(navigateTo = it)
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(
                            navController = navController,
                            startDestination = Route.CreateTripGraph
                        ) {
                            navigation<Route.CreateTripGraph>(
                                // a graph needs a start destination
                                startDestination = Route.DashboardScreen
                            ) {
                                composable<Route.DashboardScreen>() {
                                    Text("Dashboard Screen", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
                                }
                                composable<Route.AllUsersScreen> {
                                    Text("All Users Screen", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
                                }
                                composable<Route.AiTripsScreen> {
                                    Text("Ai Trip Screen", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}