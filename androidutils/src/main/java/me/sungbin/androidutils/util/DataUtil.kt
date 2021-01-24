package me.sungbin.androidutils.util

import android.content.Context

object DataUtil {
    fun readData(context: Context, name: String, _null: String?) =
        context.getSharedPreferences("pref", Context.MODE_PRIVATE).getString(name, _null)

    fun saveData(context: Context, name: String, value: String) {
        context.getSharedPreferences("pref", Context.MODE_PRIVATE).edit().run {
            putString(name, value)
            apply()
        }
    }

    fun clearData(context: Context) {
        context.getSharedPreferences("pref", Context.MODE_PRIVATE).edit().run {
            clear()
            apply()
        }
    }
}
