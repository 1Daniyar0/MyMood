 package com.example.mymoodapp

import android.Manifest

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.mymoodapp.R
import com.example.mymoodapp.achieve_screen.AchieveScreen
import com.example.mymoodapp.camera_screen.CameraPreview
import com.example.mymoodapp.camera_screen.Controls
import com.example.mymoodapp.camera_screen.switchLens
import com.example.mymoodapp.components.DialogComponent
import com.example.mymoodapp.components.SplashScreen
import com.example.mymoodapp.main_screen.MainScreen
import com.example.mymoodapp.ui.theme.*
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import kotlin.system.exitProcess


@ExperimentalGetImage class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (permissionGranted()){
            initView()
        }
        else{
            requestPermission()
        }

    }

    private fun initView(){
        setContent {
            val isDarkModeValue = isSystemInDarkTheme()
            val isDarkMode = remember { mutableStateOf(isDarkModeValue) }
            val navController = rememberNavController()
            var lens by remember {
                mutableStateOf(CameraSelector.LENS_FACING_FRONT)
            }
            MyMoodAppTheme(
                darkTheme = isDarkMode.value,
                textSize = MyMoodSize.Medium,
                corners = MyMoodCorners.Rounded,
                paddingSize = MyMoodSize.Medium
            ) {
                Scaffold(
                    backgroundColor = MyMoodTheme.colors.primaryBackground,
                    bottomBar = {BottomNavBar(navController)}) {

                    it
                    DialogComponent(R.string.exit,R.string.sure)

                    NavHost(navController = navController,
                        startDestination = "splash_screen") {

                        composable("splash_screen") {
                            SplashScreen(navController = navController)
                        }
                        // Main Screen
                        composable("Home") {
                            MainScreen()
                        }
                        composable("Camera") {
                            CameraPreview(
                                cameraLens = lens
                            )
                            Controls(
                                onLensChange = { lens = switchLens(lens) }
                            )

                        }
                        composable("Statistic") {

                        }

                        composable("Awards") {
                            AchieveScreen()
                        }

                    }

                }
            }
        }
    }

    private fun permissionGranted() =
        ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.CAMERA), 0
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initView()
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }

}




 @ExperimentalGetImage
fun closeApp(){
    val activity: MainActivity = MainActivity()
    activity.finish()
    exitProcess(0)
}



@Composable
fun BottomNavBar(navController: NavController){
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Camera", "Statistic", "Awards")
    val iconsList = listOf(Icons.Filled.Home,Icons.Filled.Person,Icons.Filled.DateRange,Icons.Filled.Star)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ){
        BottomNavigation(
            backgroundColor = MyMoodTheme.colors.primaryBackground
        ) {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(iconsList[index], contentDescription = null) },
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = {
                        navController.navigate(item)
                        selectedItem = index
                    }
                )
            }
        }
    }
}

