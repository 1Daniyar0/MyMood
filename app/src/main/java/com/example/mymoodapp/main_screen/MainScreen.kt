package com.example.mymoodapp.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mymoodapp.R
import com.example.mymoodapp.ui.theme.MyMoodTheme

@Composable
fun MainScreen(){

    Column() {
        Image(
            painter = painterResource(id = R.drawable.gradient_face),
            contentDescription = "emoji gradient for main screen",
            modifier = Modifier
                .fillMaxWidth()
                .background(MyMoodTheme.colors.primaryBackground)
                .padding(MyMoodTheme.shapes.padding)
        )
        EmotionCard("Сегодня у вас отличное настроение, продолжайте в том же духе!")
        EmotionCard("Ваше настрое нейтральное, главное не унывать, помнить что улыбка улучшает вашу жизнь!")
        EmotionCard("Видно что вам грустно, дружеска беседа может улучшить настроение")
    }

}
@Composable
fun EmotionCard(text: String){
    Row(){
        Image(
            painter = painterResource(id = R.drawable.smile_face),
            contentDescription = "Smile in emotion card",
            modifier = Modifier
                .background(MyMoodTheme.colors.primaryBackground)
                .size(150.dp, 150.dp)

        )
        Text(text = text,
            color = MyMoodTheme.colors.primaryText,
            fontSize = MyMoodTheme.typography.body.fontSize,
            modifier = Modifier
                .padding(MyMoodTheme.shapes.padding)
        )
    }
}
