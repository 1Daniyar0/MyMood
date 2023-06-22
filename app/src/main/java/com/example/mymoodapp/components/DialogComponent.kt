package com.example.mymoodapp.components

import androidx.activity.compose.BackHandler
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.core.R
import com.example.mymoodapp.closeApp
import com.example.mymoodapp.ui.theme.MyMoodColors
import com.example.mymoodapp.ui.theme.MyMoodTheme
@ExperimentalGetImage
@Composable
fun DialogComponent(title: Int, text: Int) {

    val openDialog = remember { mutableStateOf(false) }

    Column() {

        BackHandler() {
            openDialog.value = true
        }
        if (openDialog.value) {

            AlertDialog(

                onDismissRequest = { openDialog.value = false },
                title = { Text(text = stringResource(id = title), color = MyMoodTheme.colors.primaryText) },
                text = { Text(text = stringResource(id = text), color = MyMoodTheme.colors.primaryText) },

                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }
                    ) {
                        Text("Отмена", color = MyMoodTheme.colors.primaryText)
                    }
                },

                dismissButton = {

                    TextButton(

                        onClick = {
                            openDialog.value = false
                            closeApp()
                        }
                    ) {
                        Text("Выход", color = MyMoodTheme.colors.primaryText)
                    }
                },
                backgroundColor = MyMoodTheme.colors.primaryBackground,
                contentColor = Color.Black
            )
        }
    }
}
