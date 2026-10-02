package com.example.mobilelabas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
        setContentView(R.layout.loginscreen_constraint)
        renderLayout()
    }
    private fun renderLayout(){
        if (useLinear) {
            setContentView(R.layout.loginscreen_linear)
        } else {
            setContentView(R.layout.loginscreen_constraint)
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