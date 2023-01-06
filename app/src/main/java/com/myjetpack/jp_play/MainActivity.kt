package com.myjetpack.jp_play

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myjetpack.jp_play.ui.theme.JP_playTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         MainContent()
        }
    }
}

@Composable
fun UserList(users: List<User>){
    LazyColumn{
        items(users){
            UsrCard()
        }
    }
}

data class User(
    val id:Int
)

@Composable
fun  MainContent(){
    val user = User(id = 1)
    val users= remember {
        mutableStateListOf(user)
    }
    Box(modifier = Modifier.fillMaxSize()){
        UserList(users = users)
        Button(modifier = Modifier
            .padding(24.dp)
            .align(alignment = Alignment.BottomCenter), onClick = {
                users.add(User(id = 1))
        }) {
            Text(text = "Add More")
        }
    }
}
@Composable
fun UsrCard(){
    Card(elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .border(width = 1.dp, color = Color.Gray)
            .padding(12.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.image),
                contentDescription = "",
                contentScale= ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(shape = CircleShape))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(id =  R.string.dummy_text),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(12.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "View Preview")
                }
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
MainContent()
}