package com.example.composetest.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.composetest.ui.theme.ComposeTestTheme
import kotlinx.coroutines.launch

class DrawerPracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                MyDrawer()
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDrawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val screens = listOf(
        Screen.Home,
        Screen.Settings,
        Screen.Phone,
        Screen.Search,
        Screen.Lock,
    )

    val selectedScreen: MutableState<Screen> = remember {
        mutableStateOf(Screen.Home)
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "MyDrawer") }, navigationIcon = {
            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        })
    }) { paddingValues ->
        ModalNavigationDrawer(drawerState = drawerState,
            modifier = Modifier.padding(paddingValues),
            drawerContent = {
                ModalDrawerSheet {
                    screens.forEach { screen ->
                        NavigationDrawerItem(
                            icon = { Icon(screen.icon, contentDescription = screen.icon.name) },
                            label = { Text(text = screen.name) },
                            selected = screen == selectedScreen.value,
                            onClick = {
                                scope.launch { drawerState.close() }
                                selectedScreen.value = screen
                            })
                    }

                }
            }, content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    when (selectedScreen.value) {
                        Screen.Home -> HomeScreen()
                        Screen.Settings -> SettingsScreen()
                        Screen.Phone -> PhoneScreen()
                        Screen.Search -> SearchScreen()
                        Screen.Lock -> LockScreen()
                    }
                }
            }
        )
    }
}

@Composable
fun HomeScreen() {
    Text(text = "HomeScreen")
}

@Composable
fun SettingsScreen() {
    Text(text = "SettingsScreen")
}

@Composable
fun PhoneScreen() {
    Text(text = "PhoneScreen")
}

@Composable
fun SearchScreen() {
    Text(text = "SearchScreen")
}

@Composable
fun LockScreen() {
    Text(text = "LockScreen")
}

sealed class Screen(val name: String, val icon: ImageVector) {
    object Home : Screen("Home", Icons.Default.Home)
    object Settings : Screen("Settings", Icons.Default.Settings)
    object Phone : Screen("Phone", Icons.Default.Phone)
    object Search : Screen("Search", Icons.Default.Search)
    object Lock : Screen("Lock", Icons.Default.Lock)
}