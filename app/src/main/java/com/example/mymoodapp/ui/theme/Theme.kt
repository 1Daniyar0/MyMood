package com.example.mymoodapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun MyMoodAppTheme(
    textSize: MyMoodSize = MyMoodSize.Medium,
    paddingSize: MyMoodSize = MyMoodSize.Medium,
    corners: MyMoodCorners = MyMoodCorners.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        baseDarkPalette
    } else {
        baseLightPalette
    }

    val typography = MyMoodTypography(
        heading = TextStyle(
            fontSize = when(textSize){
                MyMoodSize.Small -> 24.sp
                MyMoodSize.Medium -> 28.sp
                MyMoodSize.Big -> 32.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when(textSize){
                MyMoodSize.Small -> 14.sp
                MyMoodSize.Medium -> 16.sp
                MyMoodSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontSize = when(textSize){
                MyMoodSize.Small -> 14.sp
                MyMoodSize.Medium -> 16.sp
                MyMoodSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        )
    )

    val shapes = MyMoodShape(
        padding = when(paddingSize){
            MyMoodSize.Small -> 12.dp
            MyMoodSize.Medium -> 16.dp
            MyMoodSize.Big -> 20.dp
        },
        cornersStyle = when(corners){
            MyMoodCorners.Flat -> RoundedCornerShape(0.dp)
            MyMoodCorners.Rounded -> RoundedCornerShape(8.dp)
        }
    )
    CompositionLocalProvider(
        LocalMyMoodColors provides colors,
        LocalMyMoodShape provides shapes,
        LocalMyMoodTypography provides typography,
        content = content
    )
}


