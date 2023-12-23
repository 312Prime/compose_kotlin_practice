package com.example.composetest.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composetest.ui.theme.ComposeTestTheme

class CanvasPracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                MyCanvas()
            }
        }
    }
}

@Composable
fun MyCanvas() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(Color.Black, radius = size.minDimension / 2)
            }
        }
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(200.dp)
                .background(Color.LightGray)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(Color.Black, radius = size.minDimension / 2)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .background(Color.Green)
        ) {
            Canvas(modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)) {
                drawCircle(Color.Red, radius = size.minDimension / 10)
            }
        }
    }
}