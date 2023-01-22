package com.myjetpack.jp_play

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MainContent(){
    val navController = rememberNavController()
   Surface(
        modifier = Modifier.fillMaxSize()
    ) {
      NavHost(navController = navController,
          startDestination = "home"){
          composable("home"){
              Home(navController)
          }
          //By default navigation argument type is String. But we can define the type using "NavType" as below
          composable("task?item={item}",//? stands for optional
              arguments = listOf(navArgument("item"){
              type = NavType.StringType
              defaultValue = "Item is not available"
                  //nullable=true //if default value is not set we can make it nullable
          })){
              val item = it.arguments?.getString("item")
              Task(item=item)
          }
      }
    }
}

@Preview
@Composable
fun MainPreview(){
    MainContent()
}