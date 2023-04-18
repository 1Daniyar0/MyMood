package com.example.mymoodapp.ui.theme

import android.widget.Toolbar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import org.w3c.dom.Text



data class MyMoodColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color
    )

data class MyMoodTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle
)

data class MyMoodShape(
    val padding: Dp,
    val cornersStyle: Shape,
)

object MyMoodTheme {
    val colors: MyMoodColors
        @Composable
        get() = LocalMyMoodColors.current
    val typography: MyMoodTypography
        @Composable
        get() = LocalMyMoodTypography.current
    val shapes: MyMoodShape
        @Composable
        get() = LocalMyMoodShape.current
}

enum class MyMoodSize{
    Small, Medium, Big
}

enum class MyMoodCorners {
    Flat, Rounded
}


val LocalMyMoodColors = staticCompositionLocalOf<MyMoodColors> {
    error("No colors provided")
}

val LocalMyMoodTypography = staticCompositionLocalOf<MyMoodTypography> {
    error("No font provided")
}

val LocalMyMoodShape = staticCompositionLocalOf<MyMoodShape> {
    error("No shapes provided")
}