package com.banana.realrent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.banana.realrent.ui.result.ResultScreen
import com.banana.realrent.ui.theme.RealRentTheme
import com.banana.realrent.ui.top.TopScreen
import com.banana.realrent.ui.top.TopViewModel

class MainActivity : ComponentActivity() {

    private val topViewModel by viewModels<TopViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealRentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.TOP.route) {
                        composable(route = Screen.TOP.route) {
                            TopScreen(topViewModel) {
                                navController.navigate("${Screen.RESULT.route}/$it")

                            }

                        }
                        composable(
                            route = "${Screen.RESULT.route}/{$KEY_REAL_RENT}",
                            arguments = listOf(
                                navArgument(KEY_REAL_RENT) { type = NavType.IntType },
                            )
                        ) { backStackEntry ->
                            val id = backStackEntry.arguments?.getInt(KEY_REAL_RENT) ?: 0
                            ResultScreen(id)
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val KEY_REAL_RENT = "key_real_rent"
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RealRentTheme {
        Greeting("Android")
    }
}