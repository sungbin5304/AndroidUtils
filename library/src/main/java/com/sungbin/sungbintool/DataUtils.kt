package com.sungbin.sungbintool

import android.content.Context

@Deprecated(
    message = "`Utils` is deprecated.\nPlease use `Util` instead of `Utils`.",
    replaceWith = ReplaceWith("DataUtil")
)
object DataUtils {
    fun readData(ctx: Context, name: String, _null: String): String {
        val pref = ctx.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return pref.getString(name, _null)!!
    }

    fun saveData(ctx: Context, name: String, value: String) {
        val pref = ctx.getSharedPreferences("pref", Context.MODE_PRIVATE)
        pref.edit().apply {
            putString(name, value)
            apply()
        }
    }

    fun clearData(ctx: Context) {
        val pref = ctx.getSharedPreferences("pref", Context.MODE_PRIVATE)
        pref.edit().apply {
            clear()
            apply()
        }
    }
}