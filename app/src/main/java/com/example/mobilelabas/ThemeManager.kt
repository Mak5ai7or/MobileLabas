package com.example.mobilelabas

import android.content.Context
import android.content.SharedPreferences

object ThemeManager {

    private const val PREFS = "settings"
    private const val KEY_THEME = "theme_dark"

    /** true = тёмная, false = светлая */
    fun isDark(context: Context): Boolean {
        return prefs(context).getBoolean(KEY_THEME, false)
    }

    /** Сохраняем выбор. Применяется при следующем onCreate. */
    fun setDark(context: Context, dark: Boolean) {
        prefs(context).edit().putBoolean(KEY_THEME, dark).apply()
    }

    /** id темы для setTheme() */
    fun themeRes(context: Context): Int {
        return if (isDark(context)) R.style.Theme_MobileLabas_Dark
        else R.style.Theme_MobileLabas
    }

    private fun prefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
}