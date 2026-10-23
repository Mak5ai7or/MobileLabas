package com.example.mobilelabas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilelabas.lab1.Lab1Activity
import com.example.mobilelabas.lab2.Lab2Activity
import com.example.mobilelabas.lab3.Lab3Activity
import com.example.mobilelabas.lab4.Lab4Activity
import com.example.mobilelabas.lab5.Lab5Activity
import com.example.mobilelabas.lab6.Lab6Activity
import com.example.mobilelabas.lab7.Lab7Activity


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
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
                LabItem(getString(R.string.lab6_title), Lab6Activity::class.java),
                LabItem(getString(R.string.lab7_title), Lab7Activity::class.java)
            )

            val rv = findViewById<RecyclerView>(R.id.lab_menu)
            rv.layoutManager = LinearLayoutManager(this)
            rv.adapter = LabsAdapter(labs) { lab ->
                startActivity(Intent(this, lab.activityClass))
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

        Log.d(TAG, "onCreate")
        }

    override fun onResume() {
        super.onResume()
        val desiredTheme = ThemeManager.themeRes(this)
        if (desiredTheme != appliedTheme) {
            appliedTheme = desiredTheme
            recreate()
        }
        Log.d(TAG, "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

}
