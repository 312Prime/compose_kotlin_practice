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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composetest.function.DiceActivity
import com.example.composetest.function.GraphActivity
import com.example.composetest.function.ResumeActivity
import com.example.composetest.practice.BaseToolPracticeActivity
import com.example.composetest.practice.CanvasPracticeActivity
import com.example.composetest.practice.DialogPracticeActivity
import com.example.composetest.practice.DrawerPracticeActivity
import com.example.composetest.practice.RetrofitPracticeActivity
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
        MoveButton(context, BaseToolPracticeActivity(), "Compose 기본 컴포넌트 연습장")
        MoveButton(context, RetrofitPracticeActivity(), "Retrofit 통신 연습장")
        MoveButton(context, DrawerPracticeActivity(), "Drawer 메뉴 연습장")
        MoveButton(context, DialogPracticeActivity(), "Dialog 대화창 연습장")
        MoveButton(context, CanvasPracticeActivity(), "Canvas 그림판 연습장")
        Spacer(modifier = Modifier.padding(top = 30.dp))
        Divider(thickness = 1.dp)
        MoveButton(context, ResumeActivity(), "Resume 이력서 기능", Color.Blue, Color.Gray)
        MoveButton(context, DiceActivity(), "Dice 주사위 기능", Color.Blue, Color.Gray)
        MoveButton(context, GraphActivity(), "Graph 그래프 기능", Color.Blue, Color.Gray)
    }
}

@Composable
fun MoveButton(
    context: Context,
    componentActivity: ComponentActivity,
    text: String,
    textColor: Color = Color.LightGray,
    buttonColors: Color = Color.Black,
    topPadding: Dp = 30.dp,
) {
    Spacer(modifier = Modifier.padding(top = topPadding))
    Button(
        onClick = { moveToActivity(context = context, componentActivity) },
        colors = ButtonDefaults.buttonColors(buttonColors)
    ) {
        Text(text = text, color = textColor)
    }
}

private fun moveToActivity(context: Context, componentActivity: ComponentActivity) {
    context.startActivity(
        Intent(
            context, componentActivity::class.java
        ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
    }
}