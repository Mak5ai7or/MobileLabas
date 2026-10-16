package com.example.mobilelabas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilelabas.lab1.Lab1Activity
import com.example.mobilelabas.lab2.Lab2Activity
import com.example.mobilelabas.lab3.Lab3Activity
import com.example.mobilelabas.lab4.Lab4Activity
import com.example.mobilelabas.lab5.Lab5Activity
import com.example.mobilelabas.lab6.Lab6Activity

class MainActivity : AppCompatActivity() {

    private var appliedTheme = 0

    override fun onCreate(savedInstanceState: Bundle?) {
            appliedTheme = ThemeManager.themeRes(this)
            setTheme(appliedTheme)
            LanguageManager.applySaved(this)
            super.onCreate(savedInstanceState)
            setContentView(R.layout.lab_menu)

            val labs = listOf(
                LabItem(getString(R.string.lab1_title), Lab1Activity::class.java),
                LabItem(getString(R.string.lab2_title), Lab2Activity::class.java),
                LabItem(getString(R.string.lab3_title), Lab3Activity::class.java),
                LabItem(getString(R.string.lab4_title), Lab4Activity::class.java),
                LabItem(getString(R.string.lab5_title), Lab5Activity::class.java),
                LabItem(getString(R.string.lab6_title), Lab6Activity::class.java)
            )

            val rv = findViewById<RecyclerView>(R.id.lab_menu)
            rv.layoutManager = LinearLayoutManager(this)
            rv.adapter = LabsAdapter(labs) { lab ->
                startActivity(Intent(this, lab.activityClass))
            }
            findViewById<ImageButton>(R.id.changeLanguageButton)?.setOnClickListener {
                LanguageManager.toggle(this)
            }
            findViewById<ImageButton>(R.id.changeThemeButton)?.setOnClickListener {
                toggleTheme()
            }
        }
        private fun toggleTheme() {
            val newDark = !ThemeManager.isDark(this)
            ThemeManager.setDark(this, newDark)
            recreate()
        }

    override fun onResume() {
        super.onResume()
        val desiredTheme = ThemeManager.themeRes(this)
        if (desiredTheme != appliedTheme) {
            appliedTheme = desiredTheme
            recreate()
        }
    }

    }
