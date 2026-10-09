package com.example.mobilelabas

import android.app.Activity

data class LabItem(
    val name: String,
    val activityClass: Class<out Activity>
)