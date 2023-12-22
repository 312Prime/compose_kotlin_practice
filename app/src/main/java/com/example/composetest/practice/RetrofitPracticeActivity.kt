package com.example.composetest.practice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composetest.ui.theme.ComposeTestTheme
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

// https://jsonplaceholder.typicode.com/posts/1
class RetrofitPracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {


                val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)

                InsertInputData()

            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InsertInputData() {
        var inputNumber by remember {
            mutableStateOf("")
        }
        var post by remember {
            mutableStateOf<Post?>(null)
        }
        val coroutineScope = rememberCoroutineScope()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = inputNumber,
                onValueChange = { inputNumber = it },
                label = { Text(text = "숫자를 입력해주세요") }
            )
            Button(onClick = {
                val number = inputNumber.toIntOrNull()
                if (number!=null)coroutineScope.launch {
                    post = getPostData(number)
                }
            }) {
                Text(text = "데이터 받아오기")
            }
            post?.let {
                Text(text = "UserId : " + it.userId)
                Text(text = "ID : " + it.id)
                Text(text = "Title : " + it.title)
                Text(text = "Body : " + it.body)
            }

        }
    }

    private suspend fun getPostData(number: Int): Post? {
        val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)
        val response = retrofitInstance.getPostNumber(number)
        return if (response.isSuccessful) response.body() else null
    }

}

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val client: Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance(): Retrofit {
        return client
    }

}

interface MyApi {
    @GET("posts/1")
    suspend fun getPost1(): Response<Post>

    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number: Int
    ): Response<Post>
}