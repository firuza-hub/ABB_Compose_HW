package com.example.compose

import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.DarkBlue
import com.example.compose.ui.theme.Purple200
import com.example.compose.ui.theme.Teal200

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

            Text(
                text = "Name",
                modifier = Modifier.padding(15.dp),
            )
            Text(
                text = "Surname",
                modifier = Modifier.padding(15.dp),
            )
            Text(
                text = "Phone",
                modifier = Modifier.padding(15.dp),
            )
            Text(
                text = "Email",
                modifier = Modifier.padding(15.dp),
            )
            Text(
                text = "Gender",
                modifier = Modifier.padding(15.dp),
            )
            Text(
                text = "Customer #",
                modifier = Modifier.padding(15.dp),
            )
        }
    }

}

@Composable
fun SaveButton() {
    Row(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        val context = LocalContext.current
        Button(
            onClick = {
                Toast.makeText(context, "Save profile info", Toast.LENGTH_SHORT).show()
            },modifier = Modifier.padding(0.dp).padding(20.dp)
        ) {
            Text(text = "Save")
        }
    }
}
