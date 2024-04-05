package com.example.loginui.Screens


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginui.R

@Composable
fun loginScreen(){

    var username by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp)
    ) {

        Image(painter = painterResource(id = R.drawable.a), contentDescription = "Login Image")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Login to You Account!", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            leadingIcon = {Icon(imageVector = Icons.Default.AccountCircle,
                contentDescription = "Icon")},
            trailingIcon = { Icon(imageVector = Icons.Default.Face,
                contentDescription = "faceicon")},

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),

            value = username, onValueChange = { username = it },
            placeholder = { Text(text = "Username")},
            singleLine = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Right
            )

        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = password, onValueChange = { password = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock,
                contentDescription ="Password" )},
            trailingIcon = { Icon(imageVector = Icons.Default.Check,
                contentDescription = "check")},

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Send
            ),

            placeholder = { Text(text = "Password")},
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            textStyle = TextStyle(
                textAlign = TextAlign.Right
            )
        )

        Spacer(modifier = Modifier.height(36.dp))

        ElevatedButton(
            onClick = {
                Log.i("Credential", "Email: $username Password: $password")
            },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            elevation = ButtonDefaults.elevatedButtonElevation(16.dp)
        ) {
            Text(text = "Login", fontSize = 16.sp, fontWeight = FontWeight.ExtraLight)

        }


        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Forgot Password ?",
            modifier = Modifier.clickable { },
            fontWeight = FontWeight.Light, fontSize = 15.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Or Connect Using: ", fontWeight = FontWeight.W200)

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .height(32.dp)
                .width(150.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Image(painter = painterResource(id = R.drawable.f),
                contentDescription = "Facebook",
                modifier = Modifier.clickable { })

            Image(painter = painterResource(id = R.drawable.g),
                contentDescription = "Google",
                modifier = Modifier.clickable { })

            Spacer(modifier = Modifier.width(4.dp))

            Image(painter = painterResource(id = R.drawable.x),
                contentDescription = "Twitter",
                modifier = Modifier.clickable { })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    loginScreen()
}


