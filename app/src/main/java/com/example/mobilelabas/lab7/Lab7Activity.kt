package com.example.mobilelabas.lab7

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilelabas.LanguageManager
import com.example.mobilelabas.R
import com.example.mobilelabas.ThemeManager

class Lab7Activity : AppCompatActivity(), ListFragment.OnItemSelectedListener {
    private val TAG = "Lab7Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(ThemeManager.themeRes(this))
        LanguageManager.applySaved(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab7_screen)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, ListFragment())
                .commit()
        }
    }

    override fun onItemSelected(item: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, DetailFragment.newInstance(item))
            .addToBackStack(null)
            .commit()
    }

    override fun onResume() {
        super.onResume()
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