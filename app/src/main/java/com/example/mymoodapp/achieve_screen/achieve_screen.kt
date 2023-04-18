package com.example.mymoodapp.achieve_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mymoodapp.ui.theme.MyMoodTheme


@Composable
fun AchieveScreen(){
    Column() {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
            backgroundColor = MyMoodTheme.colors.tintColor,
            contentColor = MyMoodTheme.colors.primaryText
            )
        ) {
            Text("Click")
        }
    }
}