package com.sungbin.sungbintool

import android.content.Context

object DataUtils {
    fun readData(ctx: Context, name: String, _null: String): String {
        val pref = ctx.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return pref.getString(name, _null)!!
    }

    fun saveData(ctx: Context, name: String, value: String) {
        val pref = ctx.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()

        editor.putString(name, value)
        editor.apply()
    }

    fun clearData(ctx: Context) {
        val pref = ctx.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.apply()
    }
}