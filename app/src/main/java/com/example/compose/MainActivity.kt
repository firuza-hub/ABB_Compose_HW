package com.example.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.DarkBlue
import com.example.compose.ui.theme.Teal200
import com.example.compose.ui.theme.TextFieldBG

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}


@Preview(name = "Light Mode")
@Composable
fun DefaultPreview() {
    ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Parent()

        }
    }
}

@Composable
fun Parent() {
    Column(Modifier.background(DarkBlue)) {
        Header()
        Properties()
        SaveButton()
    }
}

@Composable
fun Header() {
    Card(
        Modifier
            .height(150.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.firuza),
                contentDescription = "Profile image",
                Modifier
                    .clip(CircleShape)
                    .height(90.dp)
            )
        }
    }
}

@Composable
fun Properties() {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp),
        backgroundColor = Color.White,
        elevation = 0.dp
    ) {

        Column(modifier = Modifier.padding(10.dp, 25.dp)) {

            Property("Name")
            Property("Surname")
            Property("Phone")
            Property("Email")
            Property("Gender")
            Property("Customer #")

        }
    }

}

@Composable
fun Property(name: String) {
    Column(
        modifier = Modifier
            .padding(15.dp, 5.dp)
            .fillMaxWidth()
    ) {
        Text(text = name, color = DarkBlue, fontSize = 15.sp)
        BasicTextField(
            value = name,
            onValueChange = { v -> println(v) },
            Modifier.fillMaxWidth().padding(0.dp, 4.dp),
            textStyle = TextStyle(fontSize = 22.sp))
    }
}

@Composable
fun SaveButton() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast.makeText(context, "Save profile info", Toast.LENGTH_SHORT).show()
            }, modifier = Modifier
                .padding(0.dp)
                .padding(20.dp)
        ) {
            Text(text = "Save")
        }
    }
}
