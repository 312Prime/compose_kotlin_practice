package com.example.composetest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.function.CalendarActivity
import com.example.composetest.function.DiceActivity
import com.example.composetest.function.GraphActivity
import com.example.composetest.function.ResumeActivity
import com.example.composetest.practice.BaseToolPracticeActivity
import com.example.composetest.practice.CanvasPracticeActivity
import com.example.composetest.practice.DialogPracticeActivity
import com.example.composetest.practice.DrawerPracticeActivity
import com.example.composetest.practice.RetrofitPracticeActivity
import com.example.composetest.ui.theme.ComposeTestTheme
import com.example.composetest.uiPractice.ShoppingUIActivity
import com.example.composetest.uiPractice.ThemeActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestTheme {
                GoToPractice()
            }
        }
    }
}

@Composable
private fun GoToPractice() {
    val state = rememberScrollState()
    val practiceList = listOf(
        Pair(BaseToolPracticeActivity(), "Compose 기능 연습장"),
        Pair(RetrofitPracticeActivity(), "Retrofit 통신 연습장"),
        Pair(DrawerPracticeActivity(), "Drawer 메뉴 연습장"),
        Pair(DialogPracticeActivity(), "Dialog 대화창 연습장"),
        Pair(CanvasPracticeActivity(), "Canvas 그림판 연습장"),
    )
    val functionList = listOf(
        Pair(ResumeActivity(), "Resume 이력서 기능"),
        Pair(DiceActivity(), "Dice 주사위 기능"),
        Pair(GraphActivity(), "Graph 그래프 기능"),
        Pair(CalendarActivity(), "Calendar 달력 기능"),
    )
    val userInterfaceList = listOf(
        Pair(ThemeActivity(), "Theme 테스트 UI"),
        Pair(ShoppingUIActivity(), "Shopping 사이트 UI"),
    )
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        ButtonGridContainer("Compose 연습장", practiceList, ColorType.TYPE1)
        ButtonGridContainer("Compose 기능", functionList, ColorType.TYPE2)
        ButtonGridContainer("Compose UI", userInterfaceList, ColorType.TYPE1)
        Divider(thickness = 1.dp)
    }
}

enum class ColorType(val colors: Pair<Color, Color>) {
    TYPE1(Pair(Color.LightGray, Color.Black)),
    TYPE2(Pair(Color.Blue, Color.Gray)),
    TYPE3(Pair(Color.White, Color.DarkGray)),
}

@Composable
fun ButtonGridContainer(
    title: String,
    buttonPairList: List<Pair<ComponentActivity, String>>,
    type: ColorType
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Divider(thickness = 1.dp)
        Spacer(modifier = Modifier.padding(top = 60.dp))
        Text(text = title)
        Spacer(modifier = Modifier.padding(top = 30.dp))
        for (i in 0 until (buttonPairList.size + 1) / 2) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                for (j in 0..1) {
                    if (buttonPairList.size % 2 == 1 && i == buttonPairList.size / 2 && j == 1)
                        Box(modifier = Modifier.weight(1f)) {}
                    else Box(modifier = Modifier.weight(1f)) {
                        MoveButton(
                            componentActivity = buttonPairList[i * 2 + j].first,
                            text = buttonPairList[i * 2 + j].second,
                            type.colors.first,
                            type.colors.second
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 30.dp))
        Divider(thickness = 1.dp)
    }
}

@Composable
fun MoveButton(
    componentActivity: ComponentActivity,
    text: String,
    textColor: Color,
    buttonColors: Color,
) {
    val context = LocalContext.current
    Button(
        modifier = Modifier.fillMaxWidth(),
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