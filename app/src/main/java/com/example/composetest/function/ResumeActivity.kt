package com.example.composetest.function

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R
import com.example.composetest.ui.theme.ComposeTestTheme

class ResumeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                MyResume()
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyResume() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Android Dev Resume") })
    }) { paddingValues ->
        MyResumeContent(paddingValues = paddingValues)
    }
}

@Composable
fun MyResumeContent(paddingValues: PaddingValues) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "profile",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .background(Color.Green)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "자기소개",
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "안녕하세요 저는 개발자 이상일입니다.\n새로운 기술을 배우는 것을 좋아하고, 언제나 개발에 열정을 가지고 있습니다.",
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Kotlin, Java, JavaScript",
                color = Color.LightGray,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color.Gray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "휴대폰 번호 : 010-5307-2510", modifier = Modifier.padding(10.dp))
            Text(text = "이메일 : fhemflrh60@gmail.com", modifier = Modifier.padding(10.dp))
            Button(onClick = {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01053072510"))
                context.startActivity(intent)
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "전화 걸기")
            }
            Button(onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:fhemflrh60@gmail.com")
                }
                context.startActivity(intent)
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "이메일 보내기")
            }

        }

    }
}