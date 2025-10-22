package com.example.cooplearningproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cooplearningproj.destination.Destination
import com.example.cooplearningproj.extensions.color.darken
import com.example.cooplearningproj.extensions.color.lighten
import com.example.cooplearningproj.navigation.BottomNav
import com.example.cooplearningproj.navigation.NAV_ITEMS
import com.example.cooplearningproj.screens.EditScreen
import com.example.cooplearningproj.screens.PracticeScreen
import com.example.cooplearningproj.screens.StatsScreen
import com.example.cooplearningproj.ui.theme.CoopLearningProjTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoopLearningProjTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Temp placeholder")
                            },
                            colors = TopAppBarColors(
                                containerColor = Color.Green.darken(0.3f),
                                scrolledContainerColor = Color.Green,
                                navigationIconContentColor = Color.White,
                                titleContentColor = Color.White,
                                actionIconContentColor = Color.Red
                            )
                        )
                    },
                    bottomBar = {
                        BottomNav(navController)
                    }
                ) { innerPadding ->
                    TestComposable()
                    NavHost(
                        navController = navController,
                        startDestination = com.example.cooplearningproj.navigation.DEFAULT_DESTINATION.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Destination.Stats.route) {
                            StatsScreen()
                        }
                        composable(Destination.Edit.route) {
                            EditScreen()
                        }
                        composable(Destination.Practice.route) {
                            PracticeScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TestComposable() {
    Text("Placeholder testing text")

}
