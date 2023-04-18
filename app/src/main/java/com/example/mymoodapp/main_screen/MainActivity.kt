package com.example.mymoodapp.main_screen

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.animation.OvershootInterpolator
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import com.example.mymoodapp.R
import com.example.mymoodapp.achieve_screen.AchieveScreen
import com.example.mymoodapp.components.DialogComponent
import com.example.mymoodapp.ui.theme.*
import kotlin.system.exitProcess


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkModeValue = isSystemInDarkTheme()
            val isDarkMode = remember { mutableStateOf(isDarkModeValue) }


            MyMoodAppTheme(
                darkTheme = isDarkMode.value,
                textSize = MyMoodSize.Medium,
                corners = MyMoodCorners.Rounded,
                paddingSize = MyMoodSize.Medium
            ) {
                Surface(color = MyMoodTheme.colors.primaryBackground) {

                    DialogComponent(R.string.exit,R.string.sure)
                    Navigation()

                }
            }
        }
    }
}



fun closeApp(){
    val activity: MainActivity = MainActivity()
    activity.finish()
    exitProcess(0)
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }

        // Main Screen
        composable("BottomNavBar") {
            BottomNavBar(navController)
        }
        composable("Home") {

        }
        composable("Camera") {

        }
        composable("Statistic") {

        }
        composable("Awards") {
            AchieveScreen()
            BottomNavBar(navController)
        }

    }
}
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        // Customize the delay time
        delay(3000L)
        navController.navigate("BottomNavBar")
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        // Change the logo
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value))
    }
}

@Composable
fun BottomNavBar(navController: NavController){
    val selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Camera", "Statistic", "Awards")
    val iconsList = listOf(Icons.Filled.Home,Icons.Filled.Person,Icons.Filled.DateRange,Icons.Filled.Star)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ){
        BottomNavigation(
            backgroundColor = MyMoodTheme.colors.tintColor
        ) {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(iconsList[index], contentDescription = null) },
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = { navController.navigate(item)}
                )
            }
        }
    }
}

