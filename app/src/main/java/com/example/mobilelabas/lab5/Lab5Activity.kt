package com.example.mobilelabas.lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.setApplicationLocales
import androidx.core.os.LocaleListCompat
import androidx.core.content.edit
import com.example.mobilelabas.LanguageManager
import com.example.mobilelabas.R

class Lab5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        LanguageManager.applySaved(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab5_loginscreen)

        findViewById<Button>(R.id.enterButton).setOnClickListener {
            loginHandler()
        }
        findViewById<ImageButton>(R.id.changeLanguageButton)?.setOnClickListener {
            LanguageManager.toggle(this)
        }
    }

    // Картинка со звездными войнами на фоне
    // Цвета кнопок и полей в соответствии с фоном
    private fun loginHandler() {
        val login = findViewById<EditText>(R.id.loginSpace).text?.toString().orEmpty().trim()
        val password = findViewById<EditText>(R.id.passSpace).text?.toString().orEmpty().trim()

        when {
            login.isEmpty() || password.isEmpty() -> {
                val message = getString(R.string.error_empty_both)
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                findViewById<TextView>(R.id.resultEnter).text = message
            }
            else -> {
                val intent = Intent(this, ListActivity::class.java)
                startActivity(intent)
            }
        }
    }

}

