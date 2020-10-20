package com.sungbin.androidutils.util

import android.content.Context


object DataUtil {
    fun readData(ctx: Context, name: String, _null: String?) =
        ctx.getSharedPreferences("pref", Context.MODE_PRIVATE).getString(name, _null)

    fun saveData(ctx: Context, name: String, value: String) {
        ctx.getSharedPreferences("pref", Context.MODE_PRIVATE).edit().run {
            putString(name, value)
            apply()
        }
    }

    fun clearData(ctx: Context) {
        ctx.getSharedPreferences("pref", Context.MODE_PRIVATE).edit().run {
            clear()
            apply()
        }
    }
}