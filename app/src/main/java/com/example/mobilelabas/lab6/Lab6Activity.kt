package com.example.mobilelabas.lab6

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelabas.LanguageManager
import com.example.mobilelabas.R
import com.example.mobilelabas.ThemeManager

class Lab6Activity : AppCompatActivity() {
    private val pickText = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val selected = result.data?.getStringExtra("selected").orEmpty()
            Toast.makeText(this, selected, Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(ThemeManager.themeRes(this))
        LanguageManager.applySaved(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab5_loginscreen)

        findViewById<Button>(R.id.enterButton).setOnClickListener {
            loginHandler()
        }
        findViewById<ImageButton>(R.id.changeLanguageButton)?.setOnClickListener {
            LanguageManager.toggle(this)
        }
        findViewById<ImageButton>(R.id.changeThemeButton)?.setOnClickListener {
            toggleTheme()
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
                intent.putExtra("login", login)
                pickText.launch(intent)
            }
        }
    }
    private fun toggleTheme() {
        val newDark = !ThemeManager.isDark(this)
        ThemeManager.setDark(this, newDark)
        recreate()
    }

}

