package com.example.composetest.uiPractice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.theme.ComposeTestTheme

class ThemeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    ThemeTest()
                    TextTest()
                    TextStyle()
                    TextFont()
                    RadiusTest1()
                    RadiusTest2()
                }
            }
        }
    }
}

@Composable
fun ThemeTest() {
    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            Text(text = "HELLO")
        }
    }
}

@Composable
fun TextTest() {
    Column {
        Text(
            text = "제목",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(30.dp)
        )
        Text(
            text = "내용",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(30.dp)
        )
        Text(
            text = "하단글",
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(30.dp)
        )
        Text(
            text = "제목",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(30.dp)
        )
        Text(
            text = "내용",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(30.dp)
        )
        Text(
            text = "하단글",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(30.dp)
        )
    }
}

@Composable
fun TextStyle() {

    Column() {
        Text(
            text = "Display Large",
            style = MaterialTheme.typography.displayLarge
        )

        Text(
            text = "Display Medium",
            style = MaterialTheme.typography.displayMedium
        )

        Text(
            text = "Display Small",
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            text = "Headline Large",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Headline Medium",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Headline Small",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Title Large",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Title Medium",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = "Title Small",
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = "Body Large",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Body Medium",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Body Small",
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = "Label Large",
            style = MaterialTheme.typography.labelLarge
        )

        Text(
            text = "Label Medium",
            style = MaterialTheme.typography.labelMedium
        )

        Text(
            text = "Label Small",
            style = MaterialTheme.typography.labelSmall
        )

    }


}

@Composable
fun TextFont() {
    Column {
        Text(text = "폰트1", style = MaterialTheme.typography.bodyLarge)
        Text(text = "폰트2", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun RadiusTest1() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(Color.Red)
        ) {}
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.large)
                .background(Color.Red)
        ) {}
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(Color.Red)
        ) {}
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.small)
                .background(Color.Red)
        ) {}
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.extraSmall)
                .background(Color.Red)
        ) {}
    }
}
@Composable
fun RadiusTest2() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(Color.Blue)
        ) {}
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.large)
                .background(Color.Blue)
        ) {}
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(Color.Blue)
        ) {}
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Composable
fun TestPreview1() {
    RadiusTest2()
}