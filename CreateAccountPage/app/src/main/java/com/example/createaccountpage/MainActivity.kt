package com.example.createaccountpage

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.createaccountpage.ui.theme.CreateAccountPageTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }

            CreateAccountPageTheme(darkTheme = isDarkMode) {
                CreateAccountScreen(
                    isDarkMode = isDarkMode,
                    onThemeChange = { isDarkMode = !isDarkMode }
                )
            }
        }
    }
}


@Composable
fun CreateAccountScreen(
    isDarkMode: Boolean,
    onThemeChange: () -> Unit
) {
    val context = LocalContext.current

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val genders = listOf("Male", "Female")
    var selectedGender by remember { mutableStateOf(genders.first()) }

    var agreed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Create Account",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // 1) First & Last name in one row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name") },
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text(text = "Last Name") },
                modifier = Modifier.weight(1f)
            )
        }

        // 2) Username
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        // 3) Password (hidden)
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        // 4) Gender (Radio buttons)
        Text("Gender", style = MaterialTheme.typography.titleMedium)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            genders.forEach { gender ->
                Row(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable { selectedGender = gender },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedGender == gender,
                        onClick = { selectedGender = gender }
                    )
                    Text(gender)
                }
            }
        }

        // 5) Agreement
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(checked = agreed, onCheckedChange = { agreed = it })
            Text("I agree to the Terms and Conditions.")
        }

        Spacer(Modifier.height(8.dp))

        // 6) Buttons (Clear & Submit) side by side
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = {
                    firstName = ""
                    lastName = ""
                    username = ""
                    password = ""
                    selectedGender = genders.first()
                    agreed = false
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Clear")
            }

            Button(
                onClick = {
                    val fullName = "${firstName} ${lastName}".trim()
                    val message = "Name: $fullName\nUsername: $username\nGender: $selectedGender"
                    Toast
                        .makeText(context, message, Toast.LENGTH_LONG)
                        .show()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Submit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CreateAccountPageTheme {
        CreateAccountScreen(isDarkMode = true, onThemeChange = {})
    }
}