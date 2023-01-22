package com.myjetpack.jp_play
import android.graphics.fonts.FontStyle
import android.widget.Toast
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun Task (navController: NavController?=null, item: String?=null) {

    val context = LocalContext.current
    Toast.makeText(context, item, Toast.LENGTH_LONG).show()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(
            top = 24.dp, bottom = 12.dp, start = 12.dp, end = 12.dp
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
        TitleText(title = "Task Details", 20.sp, fontWeight = FontStyle.FONT_WEIGHT_BOLD)
        LazyColumn {
            var i = 0
            items((0..4).toList()){
                TaskDetailsCard("Task ${++i}")
            }
        }
    }
}

@Composable
fun TaskDetailsCard(task: String) {
    Card(elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 8.dp)
            .clickable {
               // navController?.navigate("home")
            }
    ) {
        Row(modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.List, contentDescription = "",
                modifier = Modifier.padding(10.dp))
            TitleDetailsText(title = task, size = TextUnit.Unspecified, fontWeight = FontStyle.FONT_WEIGHT_NORMAL)
        }
    }
}

@Composable
fun TitleDetailsText(title: String, size: TextUnit, fontWeight: Int) {
    Text(
        text = title,
        fontSize = size,
        fontWeight = FontWeight(fontWeight)
    )
}