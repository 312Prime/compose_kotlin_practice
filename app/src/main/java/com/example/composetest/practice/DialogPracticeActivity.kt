package com.example.composetest.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.theme.ComposeTestTheme

class DialogPracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                MyDialog()
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDialog() {

    var dialogFlag by remember {
        mutableStateOf(false)
    }

    var inputText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { dialogFlag = true }) {
            Text(text = "Open Dialog")
        }

        if (dialogFlag) {
            AlertDialog(
                onDismissRequest = { },
                title = { Text(text = "Dialog Title") },
                text = {
                    TextField(value = inputText, onValueChange = { inputText = it })
                },
                confirmButton = {
                    Button(
                        onClick = { dialogFlag = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue
                        )
                    ) {
                        Text(text = "OK")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = { dialogFlag = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.LightGray
                        )
                    ) {
                        Text(text = "NO")
                    }
                })
        }
        if (inputText.isNotEmpty()) {
            Text(
                text = "입력된 텍스트 : $inputText",
                fontSize = 40.sp,
                lineHeight = 50.sp
            )
        }

    }
}