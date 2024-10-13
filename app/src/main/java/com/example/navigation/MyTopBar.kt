package com.example.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.navigation.NavController


@Composable
fun MyTopBar(navController: NavController, title: String) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = { /* Menu icon onClick */ }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu Icon")
            }
        },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Default.MoreVert, contentDescription = "More Icon")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(onClick = {
                    expanded = false
                    navController.navigate("info")
                }) {
                    Text("Info")
                }
                DropdownMenuItem(onClick = {
                    expanded = false
                    navController.navigate("settings")
                }) {
                    Text("Settings")
                }
            }
        }
    )
}
