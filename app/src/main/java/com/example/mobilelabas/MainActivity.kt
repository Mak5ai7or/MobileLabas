package com.example.mobilelabas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.setApplicationLocales
import androidx.core.os.LocaleListCompat
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val savedLang = getSharedPreferences("settings", MODE_PRIVATE)
            .getString("language", "ru")

        if (AppCompatDelegate.getApplicationLocales().isEmpty) {
            setApplicationLocales(
                LocaleListCompat.forLanguageTags(savedLang!!)
            )
        }
        renderLayout()

    }
    private fun renderLayout() {
        setContentView(R.layout.loginscreen_constraint)
        findViewById<Button>(R.id.enterButton).setOnClickListener {
            loginHandler()
        }
        findViewById<ImageButton>(R.id.changeLanguageButton).setOnClickListener {
            changeLanguage()
        }
    }
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
                intent.putExtra("login", login)
                startActivity(intent)
            }
        }
    }
    private fun changeLanguage() {
        val currentLanguage = AppCompatDelegate.getApplicationLocales()
            .toLanguageTags()
            .ifEmpty { "ru" }

        val nextLanguage = if (currentLanguage.startsWith("ru")) "en" else "ru"

        getSharedPreferences("settings", MODE_PRIVATE)
            .edit {
                putString("language", nextLanguage)
            }

        setApplicationLocales(LocaleListCompat.forLanguageTags(nextLanguage))
        }
    }

