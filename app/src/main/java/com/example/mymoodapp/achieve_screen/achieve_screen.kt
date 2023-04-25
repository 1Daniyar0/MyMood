package com.example.mymoodapp.achieve_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mymoodapp.R
import com.example.mymoodapp.ui.theme.MyMoodShape
import com.example.mymoodapp.ui.theme.MyMoodTheme


@Composable
fun AchieveScreen(){
    Column(
        modifier = Modifier
            .background(MyMoodTheme.colors.secondaryBackground)
            .fillMaxSize()
    ) {
        AchieveRaw()
        AchieveRaw()
        AchieveRaw()
    }
}

@Composable
fun AchieveRaw(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = MyMoodTheme.shapes.padding, top = MyMoodTheme.shapes.padding, end = MyMoodTheme.shapes.padding),
        horizontalArrangement = Arrangement.Center
    ) {
        Card(
            backgroundColor = MyMoodTheme.colors.primaryBackground,
            shape = MyMoodTheme.shapes.cornersStyle,
            modifier = Modifier.weight(0.5f)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cup_image),
                    contentDescription = "achieve image",
                    modifier = Modifier
                        .background(Color.White)
                        .size(150.dp, 150.dp)
                        .padding(MyMoodTheme.shapes.padding)
                )
                Text(text = "This is achieve",
                    color = MyMoodTheme.colors.primaryText,
                    fontSize = MyMoodTheme.typography.body.fontSize,
                    modifier = Modifier
                        .padding(MyMoodTheme.shapes.padding)
                )
            }
        }

        Spacer(modifier = Modifier.size(MyMoodTheme.shapes.padding))

        Card(
            backgroundColor = MyMoodTheme.colors.primaryBackground,
            shape = MyMoodTheme.shapes.cornersStyle,
            modifier = Modifier.weight(0.5f)

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cup_image),
                    contentDescription = "achieve image",
                    modifier = Modifier
                        .background(Color.White)
                        .size(150.dp, 150.dp)
                        .padding(MyMoodTheme.shapes.padding)
                )
                Text(text = "This is achieve",
                    color = MyMoodTheme.colors.primaryText,
                    fontSize = MyMoodTheme.typography.body.fontSize,
                    modifier = Modifier
                        .padding(MyMoodTheme.shapes.padding)
                )
            }
        }
    }
}