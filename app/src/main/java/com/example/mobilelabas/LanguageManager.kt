package com.example.mobilelabas

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.setApplicationLocales
import androidx.core.content.edit
import androidx.core.os.LocaleListCompat

object LanguageManager {

    private const val PREFS = "settings"
    private const val KEY_LANG = "language"
    private const val DEFAULT_LANG = "ru"

    fun applySaved(context: Context) {
        if (AppCompatDelegate.getApplicationLocales().isEmpty) {
            val saved = context
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .getString(KEY_LANG, DEFAULT_LANG) ?: DEFAULT_LANG
            setApplicationLocales(LocaleListCompat.forLanguageTags(saved))
        }
    }

    fun toggle(context: Context) {
        val current = AppCompatDelegate.getApplicationLocales()
            .toLanguageTags()
            .ifEmpty { DEFAULT_LANG }

        val next = if (current.startsWith("ru")) "en" else "ru"

        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit { putString(KEY_LANG, next) }

        setApplicationLocales(LocaleListCompat.forLanguageTags(next))
    }
}