package com.sungbin.sungbintool

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager

@Deprecated(
    message = "This util may not working."
)
object ColorUtils {
    fun setStatusBarColor(act: Activity, color: Int) {
        val window = act.window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }

    fun setStatusBarIconColorGray(act: Activity) {
        val view = act.window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else if (Build.VERSION.SDK_INT >= 21) {
            act.window.statusBarColor = Color.BLACK
        }
    }

    fun setNavigationBarColor(act: Activity, color: Int) {
        val window = act.window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = color
        }
    }
}