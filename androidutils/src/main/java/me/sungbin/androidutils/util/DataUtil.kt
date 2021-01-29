/*
 * Create by Sungbin Ji on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/sungbin5304/AndroidUtils/blob/master/LICENSE
 */

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
