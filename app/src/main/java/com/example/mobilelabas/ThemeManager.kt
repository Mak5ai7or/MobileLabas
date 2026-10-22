package com.example.mobilelabas

import android.content.Context
import android.content.SharedPreferences

object ThemeManager {

    private const val PREFS = "settings"
    private const val KEY_THEME = "theme_mode"

    const val THEME_DAY = "day"
    const val THEME_NIGHT = "night"
    const val THEME_STARWARS = "starwars"

    private var cachedMode: String? = null

    fun currentMode(context: Context): String {
        cachedMode?.let {return it}
        val value = prefs(context).getString(KEY_THEME, THEME_DAY) ?: THEME_DAY
        cachedMode = value
        return value
    }
    fun setMode(context: Context, mode: String) {
        prefs(context).edit().putString(KEY_THEME, mode).commit()
        cachedMode = mode
    }

    fun themeRes(context: Context): Int = when (currentMode(context)) {
        THEME_NIGHT -> R.style.Theme_MobileLabas_Dark
        THEME_STARWARS -> R.style.Theme_MobileLabas_Starwars
        else -> R.style.Theme_MobileLabas
    }

    private fun prefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
}