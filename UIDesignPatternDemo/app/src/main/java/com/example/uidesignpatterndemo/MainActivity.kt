package com.example.uidesignpatterndemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {        // From Material 3 template
                InputFormDemo()
            }
        }
    }
}


@Composable
fun InputFormDemo() {
    var name by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") }
        )
        Spacer(Modifier.padding(top = 12.dp))
        Button(onClick = { /* TODO: handle click */ }) {
            Text("Submit")
        }
        if (name.isNotBlank()) {
            Spacer(Modifier.padding(top = 12.dp))
            Text("Hello, $name!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InputFormDemoPreview() {
    MaterialTheme {
        InputFormDemo()
    }
}