package com.example.mobilelabas.lab6

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
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

    private var appliedTheme = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        appliedTheme = ThemeManager.themeRes(this)
        setTheme(appliedTheme)
        LanguageManager.applySaved(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab5_loginscreen)

        findViewById<Button>(R.id.enterButton).setOnClickListener {
            loginHandler()
        }
        findViewById<ImageButton>(R.id.changeLanguageButton)?.setOnClickListener {
            LanguageManager.toggle(this)
        }
        findViewById<ImageButton>(R.id.changeThemeButton)?.setOnClickListener { view ->
            val wrapper = ContextThemeWrapper(this, R.style.PopupForTheme)
            val popup = PopupMenu(wrapper, view)

            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)

            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.to_day -> {
                        ThemeManager.setMode(this, ThemeManager.THEME_DAY)
                        appliedTheme = ThemeManager.themeRes(this)
                        recreate()
                        true
                    }
                    R.id.to_night -> {
                        ThemeManager.setMode(this, ThemeManager.THEME_NIGHT)
                        appliedTheme = ThemeManager.themeRes(this)
                        recreate()
                        true
                    }
                    R.id.to_starwars -> {
                        ThemeManager.setMode(this, ThemeManager.THEME_STARWARS)
                        appliedTheme = ThemeManager.themeRes(this)
                        recreate()
                        true
                    }
                    else -> false
                }
            }
            popup.show()
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
                pickText.launch(intent)
            }
        }
    }
}

