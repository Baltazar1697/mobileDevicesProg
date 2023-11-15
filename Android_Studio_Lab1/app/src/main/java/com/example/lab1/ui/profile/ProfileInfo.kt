package com.example.lab1.ui.profile


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter


@Composable
fun ProfileInfo(icon: Painter,number: Int, text: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Gray
            )
        ) {
            Icon(painter = icon, contentDescription = "icon")
        }
        Row {
            Text(
                text = number.toString()+" "+text,
                style = androidx.compose.ui.text.TextStyle(
                    color = Color.Gray
                )
            )
        }

    }
}
