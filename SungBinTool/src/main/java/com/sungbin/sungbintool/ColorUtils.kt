package com.sungbin.sungbintool

import android.app.Activity
import android.os.Build
import android.view.WindowManager

object ColorUtils {
    fun setStatusBarColor(act: Activity, color: Int){
        val window = act.window
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }
}