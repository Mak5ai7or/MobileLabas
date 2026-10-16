package com.example.mobilelabas.lab3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelabas.LanguageManager
import com.example.mobilelabas.R
import com.example.mobilelabas.ThemeManager

class Lab3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(ThemeManager.themeRes(this))
        LanguageManager.applySaved(this)
        super.onCreate(savedInstanceState)
        renderLayout()
    }
    private fun renderLayout() {
        setContentView(R.layout.lab3_loginscreen)
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