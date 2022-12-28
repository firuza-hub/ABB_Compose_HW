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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.DarkBlue

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
    val mockUser = UserProfile(
        "Firuza", "Aliyeva",
        "+994503490158", "fsaliyeva96@gmail.com",
        "female", "meow", R.drawable.firuza
    )
    ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Parent(mockUser)

        }
    }
}

@Composable
fun Parent(user: UserProfile) {
    Column(Modifier.background(DarkBlue)) {
        Header(user.avatarRes)
        Properties(user)
        SaveButton()
    }
}

@Composable
fun Header(imgRes: Int) {
    Card(
        Modifier
            .height(150.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = imgRes),
                contentDescription = "Profile image",
                Modifier
                    .clip(CircleShape)
                    .height(90.dp)
            )
            Box(
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ), 160f
                        )
                    )
            ) {

            }
        }
    }
}

@Composable
fun Properties(user: UserProfile) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        backgroundColor = Color.White,
        elevation = 0.dp
    ) {

        Column(modifier = Modifier.padding(10.dp, 25.dp)) {

            Property("Name", user.name)
            Property("Surname", user.Surname)
            Property("Phone", user.phone)
            Property("Email", user.email)
            Property("Gender", user.gender)
            Property("Customer #", user.customerNo)

        }
    }

}

@Composable
fun Property(name: String, value: String) {
    Column(
        modifier = Modifier
            .padding(15.dp, 7.dp)
            .fillMaxWidth()
    ) {
        Text(text = name, color = DarkBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        BasicTextField(
            value = value,
            onValueChange = { v -> println(v) },
            Modifier
                .fillMaxWidth()
                .padding(top = 2.dp, bottom = 4.dp),
            textStyle = TextStyle(fontSize = 19.sp)
        )
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


data class UserProfile(
    val name: String,
    val Surname: String,
    val phone: String,
    val email: String,
    val gender: String,
    val customerNo: String,
    val avatarRes: Int
)
