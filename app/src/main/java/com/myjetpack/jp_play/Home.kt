package com.myjetpack.jp_play

import android.graphics.fonts.FontStyle.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController?=null) {
     Column(modifier = Modifier
         .fillMaxSize()
         .padding(
             top = 24.dp,
             bottom = 12.dp,
             start = 12.dp,
             end = 12.dp
         )) {
         TextField(value = "",
             onValueChange = {
                 
             }, modifier = Modifier
                 .fillMaxWidth()
                 .wrapContentHeight(),
         shape = RoundedCornerShape(5.dp),
         leadingIcon = { 
             Icon(
                 imageVector = Icons.Default.Search,
                 ""
             )
         }
         )
         Spacer(modifier = Modifier.padding(vertical = 12.dp))
         TitleText(title = "My Tasks", 20.sp, fontWeight = FONT_WEIGHT_BOLD)
         LazyColumn {
             var i = 0
             items((0..5).toList()){
                 TaskCard("Item ${++i}", navController)
             }
         }
     }
}

@Composable
fun TaskCard(task: String, navController: NavHostController?) {
    Card(elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 8.dp)
            .clickable {
                navController?.navigate("task?item=$task")//getting the task as argument
            }
    ) {
        Row(modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.List, contentDescription = "",
                modifier = Modifier.padding(10.dp))
            TitleText(title = task, size = TextUnit.Unspecified, fontWeight = FONT_WEIGHT_NORMAL)
        }
    }
}

@Composable
fun TitleText(title: String, size: TextUnit, fontWeight: Int) {
    Text(text = title,
        fontSize= size,
        fontWeight= FontWeight(fontWeight)
    )
}
