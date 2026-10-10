package com.example.mobilelabas.lab2

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.mobilelabas.R

class Lab2Activity : ComponentActivity() {
    private var useLinear = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab2_loginscreen_constraint)
        renderLayout()
    }
    private fun renderLayout(){
        if (useLinear) {
            setContentView(R.layout.lab2_loginscreen_linear)
        } else {
            setContentView(R.layout.lab2_loginscreen_constraint)
        }

        val changeButton = findViewById<Button>(R.id.changeLayoutButton)
        changeButton.text = if (useLinear) {
            "Сменить на ConstraintLayout"
        } else {
            "Сменить на LinearLayout"
        }
        changeButton.setOnClickListener {
            useLinear = !useLinear
            renderLayout()
        }

        findViewById<Button>(R.id.enterButton).setOnClickListener {
            var i = 1;
        }
    }
}