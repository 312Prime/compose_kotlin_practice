package com.example.composetest.practice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.example.composetest.R
import com.example.composetest.ui.theme.ComposeTestTheme

class BaseToolPracticeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                MyShowHideEx2()
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
        TextField(value = textState, onValueChange = { textState = it }, label = {
            Text(text = "text 입력 공간")
        })
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
            onClick = { textStateOutput = textStateInput }, modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "입력하기")
        }
        Text(text = "결과값 텍스트 : $textStateOutput")
    }
}

@Composable
fun MyImageTest() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "icon"
    )
}

@Composable
fun WebImageTest() {
    AsyncImage(
        model = "https://s3.ap-northeast-2.amazonaws.com/img.kormedi.com/news/article/__icsFiles/artimage/2016/12/12/c_km601/403416_540_1.jpg",
        contentDescription = "cheese"
    )
}

@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Blue)
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Text(text = "왼쪽 위")
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Green)
                .padding(16.dp)
                .align(Alignment.TopCenter)
        ) {
            Text(text = "중앙 위")
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Gray)
                .padding(16.dp)
                .align(Alignment.TopEnd)
        ) {
            Text(text = "오른쪽 위")
        }

        Button(
            onClick = {}, modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Text(text = "중앙 왼쪽")
        }
        Button(
            onClick = {}, modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "중앙 중앙")
        }
        Button(
            onClick = {}, modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(text = "중앙 오른쪽")
        }


        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Blue)
                .padding(16.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(text = "왼쪽 아래")
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Green)
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(text = "중앙 아래")
        }
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Gray)
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        ) {
            Text(text = "오른쪽 아래")
        }
    }
}

@Composable
fun RowTest() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Item1", style = TextStyle(background = Color.Blue), fontSize = 30.sp
        )
        Text(
            text = "Item2", style = TextStyle(background = Color.Red), fontSize = 30.sp
        )
        Text(
            text = "Item3", style = TextStyle(background = Color.Green), fontSize = 30.sp
        )
    }
}

@Composable
fun ColumnRowTest1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.Gray)
    ) {
        Text(
            text = "안녕하세요", color = Color.Blue, fontSize = 20.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "왼쪽")
            Text(text = "중앙")
            Text(text = "오른쪽")
        }
        Text(
            text = "안녕하세요", color = Color.Red, fontSize = 20.sp
        )
    }
}

@Composable
fun ColumnRowTest2() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.Cyan)
            .border(border = BorderStroke(5.dp, color = Color.Blue)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.padding(top = 20.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "안드로이드 이미지",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color.Green)
            )
        }

        Text(
            text = "312Prime",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 50.dp)
        )

        Text(
            text = "Developer", fontSize = 15.sp, modifier = Modifier.padding(10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "이메일",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                text = "fhemflrh60@gmail.com",
                fontSize = 15.sp,
                modifier = Modifier.padding(10.dp),
                color = Color.Blue
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "연락처",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                text = "010-5307-2510", fontSize = 15.sp, modifier = Modifier.padding(10.dp)
            )
        }

    }
}

@Composable
fun CardTest(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        shape = RoundedCornerShape(50.dp),
        border = BorderStroke(1.dp, Color.Black)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontSize = 30.sp
            )
        }
    }
}

@Composable
fun MyWebView(url: String) {

    AndroidView(factory = {
        WebView(it).apply {
            loadUrl(url)
        }
    })
}

@Composable
fun MySurface1() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        color = Color.Red,
        shape = RoundedCornerShape(20.dp),
        shadowElevation = 20.dp
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green)
        ) {
            Text(text = "클릭해보세요")
        }
    }
}

@Composable
fun MySurface2() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.LightGray,
        border = BorderStroke(2.dp, Color.Red),
        contentColor = Color.Blue
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(200.dp),
                color = Color.Red,
            ) {
                Text(
                    text = "This is Jetpack Compose",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.wrapContentSize()
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "This is Jetpack Compose Ex")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold() {
    Scaffold(
        topBar = { MyTopBar() },
        floatingActionButton = { MyFloatingActionButton() },
        bottomBar = { MyBottomBar() }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(text = "this is content")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    TopAppBar(
        title = {
            Text(text = "Main")
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        },
        actions = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Button")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(Color.LightGray)
    )
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
    }
}

@Composable
fun MyBottomBar() {
    BottomAppBar(containerColor = Color.LightGray) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings")
            }
        }
    }
}

@Composable
fun MyLazyColumnEx() {
    val textList = ('A'..'Z').toList().map { it.toString() }.let { it + it + it + it }

    LazyColumn {
        items(textList) { item ->
            Text(
                text = item,
                fontSize = 60.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun MyLazyRowEx() {
    val textList = ('A'..'Z').toList().map { it.toString() }.let { it + it + it + it }

    LazyRow {
        items(textList) { item ->
            Text(text = item, fontSize = 100.sp, modifier = Modifier.clickable {
                println("Clicked item : $item")
            })
        }
    }
}

@Composable
fun MyProgressIndicator() {
    var progress by remember { mutableFloatStateOf(0.0f) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { if (progress < 1.0f) progress += 0.1f }) {
            Text(
                text = "행복 게이지",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.height(10.dp),
            color = Color.Blue,
            trackColor = Color.LightGray,
        )

        CircularProgressIndicator(
            progress = progress,
            color = Color.Blue
        )
    }
}

@Composable
fun MyTextArea1() {
    Column {
        Text(
            text = "안녕",
            fontSize = 100.sp,
            color = Color.Black
        )
        Text(
            text = "나는",
            fontSize = 100.sp,
            color = Color.Gray
        )
        Text(
            text = "누구야",
            fontSize = 100.sp,
            color = Color.Blue
        )
    }
}

@Composable
fun MyTextArea2() {
    Column {
        MyTextFormat1(text = "안녕", fontSize = 100.sp, color = Color.Black)
        MyTextFormat1(text = "나는", fontSize = 100.sp, color = Color.Gray)
        MyTextFormat1(text = "누구야", fontSize = 100.sp, color = Color.Blue)
    }
}

@Composable
fun MyTextFormat1(text: String, fontSize: TextUnit, color: Color) {
    Text(text = text, fontSize = fontSize, color = color)
}

@Composable
fun MyTextArea3() {
    MyTextFormat2 {
        Text(
            text = "안녕",
            fontSize = 100.sp,
            color = Color.Black
        )
    }
}

@Composable
fun MyShowHideEx1() {
    var isButtonVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { isButtonVisible = !isButtonVisible }) {
            if (isButtonVisible) {
                Text(text = "숨기기", fontSize = 50.sp)
            } else {
                Text(text = "보이기", fontSize = 50.sp)
            }
        }
        if (isButtonVisible) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "짠짠짠", fontSize = 50.sp)
            }
        }
    }
}

@Composable
fun MyShowHideEx2() {
    var switchState by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.padding(20.dp)) {
        Switch(checked = switchState, onCheckedChange = { checked ->
            switchState = checked
        })

        Text(text = if (switchState) "ON" else "OFF")

        if (switchState) {
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "짠짠짠",
                    fontSize = 100.sp
                )
            }
        }
    }
}

@Composable
fun MyTextFormat2(content: @Composable () -> Unit) {
    content()
    content()
    content()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyShowHideEx2()
}
