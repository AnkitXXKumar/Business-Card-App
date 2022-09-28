package com.example.bussiness_cardapp

import android.media.midi.MidiDevice.MidiConnection
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.bussiness_cardapp.ui.theme.Bussiness_CardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bussiness_CardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

//Main Function

@Composable
fun CreateBizCard(){
    val buttonClickedState  = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        Card(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(20.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(15.dp)
        ) {
            Column(modifier = Modifier
                .height(300.dp)
                .padding(top = 10.dp), verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider(modifier = Modifier.padding(top = 10.dp))
                CreateInfo()
                Button(
                    onClick = {
                              buttonClickedState.value = !buttonClickedState.value
                }
                    , elevation =  ButtonDefaults.elevation(
                    defaultElevation = 15.dp
                ) , modifier = Modifier
                        .padding(top = 10.dp)
                        .height(50.dp)
                        .width(150.dp), shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "My Projects" , fontWeight = FontWeight.Bold)
                }
                if (buttonClickedState.value){
                    Content()
                }else
                { Box{}
                }

            }
        }
    }
}

@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)) ,
            border = BorderStroke(width = 2.dp , Color.Gray)
        ) {
            Protfolio(data = listOf("Ecommerce App", "Bitcoin App" , "Weather App" , "Quiz Game"))
        }
    }

}

@Composable
fun Protfolio(data: List<String>) {
        LazyColumn{
            items(data){item ->
                Card(modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                    shape = RectangleShape , elevation = 5.dp) {
                    Row(modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colors.surface)
                        .padding(16.dp)) {
                        Image(painterResource(id = R.drawable.projectsdemo),
                            contentDescription = "one",
                            modifier = Modifier.size(80.dp),
                            contentScale = ContentScale.Crop)
                        Column(modifier = Modifier.padding(7.dp).align(alignment = CenterVertically)) {
                            Text(text = item , fontWeight = FontWeight.Bold , modifier = Modifier.padding(start = 10.dp))
                        }
                    }
                }
            }
        }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(text = "Ankit", style = MaterialTheme.typography.h2, fontWeight = FontWeight.Bold)
        Text(
            text = "Compose Android Developer",
            color = Color.Gray,
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = "12AnkitX@gmail.com",
            color = Color.Gray,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(4.dp, Color.LightGray),
        elevation = 4.dp,
        color = Color.White
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Bussiness_CardAppTheme {
        CreateBizCard()
    }
}