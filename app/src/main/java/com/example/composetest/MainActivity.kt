package com.example.composetest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.practice.BaseToolPracticeActivity
import com.example.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestTheme {
                GoToPractice(context = this)
            }
        }
    }
}

@Composable
private fun GoToPractice(context: Context) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(top = 30.dp))
        Text(text = "Compose 연습장")
        Spacer(modifier = Modifier.padding(top = 30.dp))
        Divider(thickness = 1.dp)
        Spacer(modifier = Modifier.padding(top = 30.dp))
        Button(onClick = { moveToPracticeActivity(context = context) }) {
            Text(text = "Compose 기본 컴포넌트 연습장")
        }
    }
}

private fun moveToPracticeActivity(context: Context) {
    context.startActivity(
        Intent(
            context, BaseToolPracticeActivity::class.java
        ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
    }
}