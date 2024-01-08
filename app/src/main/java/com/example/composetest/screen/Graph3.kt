package com.example.composetest.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.theme.ComposeTestTheme

@Composable
fun Graph3() {
    Text(text = "3", fontSize = 30.sp)
}

@Preview(showBackground = true)
@Composable
fun Graph3Preview() {
    ComposeTestTheme {
        Graph3()
    }
}