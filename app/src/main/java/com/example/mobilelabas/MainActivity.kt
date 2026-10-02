package com.example.mobilelabas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobilelabas.ui.theme.Laba2Theme

class MainActivity : ComponentActivity() {
    private var useLinear = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        renderLayout()
    }
    private fun renderLayout() {
        setContentView(R.layout.loginscreen_constraint)
        findViewById<Button>(R.id.enterButton).setOnClickListener {
            loginHandler()
        }
    }
    private fun loginHandler() {
        val login = findViewById<EditText>(R.id.loginSpace).text?.toString().orEmpty().trim()
        val password = findViewById<EditText>(R.id.passSpace).text?.toString().orEmpty().trim()

        val message = when {
            login.isEmpty() || password.isEmpty() -> "Вы не ввели логин и (или) пароль"
            else -> "Логин: $login Пароль: $password"
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        findViewById<TextView>(R.id.resultEnter).text = message
    }
}