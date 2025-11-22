package com.practice.socialfeed.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.socialfeed.ui.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onLoginSuccess: () -> Unit
) {
    val username by viewModel.username.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))   // 👈 Shift whole UI down

        Text(
            text = "Welcome",
            fontSize = 32.sp,                      // 👈 Increased size
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = username,
            onValueChange = viewModel::onUsernameChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            label = { Text("Enter any name") }
        )

        Button(
            onClick = {
                if (viewModel.canLogin()) {
                    onLoginSuccess()
                }
            },
            modifier = Modifier
                .padding(top = 24.dp)
        ) {
            Text("Continue")
        }
    }
}
