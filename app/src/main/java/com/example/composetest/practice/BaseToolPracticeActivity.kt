package com.example.composetest.practice

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composetest.R
import com.example.composetest.ui.theme.ComposeTestTheme

class BaseToolPracticeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                WebImageTest()
            }
        }
    }
}

@Composable
fun MyTextEx() {

    Text(
        text = "안녕하세요 텍스트 예제입니다.",
        fontSize = 30.sp,
        color = Color.Red,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(30.dp),
        style = TextStyle(background = Color.Blue)
    )
}

@Composable
fun MyButton() {
    val context: Context = LocalContext.current

    Button(
        onClick = {
            Log.d("Main", "클릭 완료")
            Toast.makeText(context, "클릭 완료", Toast.LENGTH_SHORT).show()
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
    ) {
        Text(
            text = "버튼", lineHeight = 50.sp, fontSize = 30.sp, color = Color.Black
        )
    }
}

@Composable
fun SimpleCountButton() {
    var count by remember { mutableStateOf(0) }

    Button(
        onClick = { count++ },
        modifier = Modifier.fillMaxSize(),

        ) {
        Text(text = "count : $count")
    }

}

@Composable
fun ColumnTest() {
    Column(
        modifier = Modifier.padding(30.dp)
    ) {
        Text(
            text = "안녕하세요", fontSize = 30.sp
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Divider(thickness = 1.dp)
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = "반갑습니다", fontSize = 30.sp
        )
        Spacer(modifier = Modifier.padding(15.dp))
        Divider(thickness = 1.dp)
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = "다시만나요", fontSize = 30.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var textState by remember { mutableStateOf("") }
    var outLineTextState by remember { mutableStateOf("") }
    var textStateInput by remember { mutableStateOf("") }
    var textStateOutput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = textState,
            onValueChange = { textState = it },
            label = {
                Text(text = "text 입력 공간")
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = outLineTextState,
            onValueChange = { outLineTextState = it },
            label = { Text(text = "outlinedText 입력 공간") },
        )
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(value = textStateInput,
            onValueChange = { textStateInput = it },
            label = { Text(text = "button 출력") })
        Spacer(modifier = Modifier.padding(5.dp))
        Button(
            onClick = { textStateOutput = textStateInput },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "입력하기")
        }
        Text(text = "결과값 텍스트 : $textStateOutput")
    }
}

@Composable
fun MyImageTest(){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "icon"
    )
}

@Composable
fun WebImageTest(){
    AsyncImage(
        model = "https://s3.ap-northeast-2.amazonaws.com/img.kormedi.com/news/article/__icsFiles/artimage/2016/12/12/c_km601/403416_540_1.jpg",
        contentDescription = "cheese"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
        MyImageTest()
    }
}
