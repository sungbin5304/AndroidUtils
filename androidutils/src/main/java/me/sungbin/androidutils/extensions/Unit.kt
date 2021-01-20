package me.sungbin.androidutils.extensions

import android.os.Handler
import android.os.Looper

/**
 * Created by SungBin on 2020-06-10.
 */

fun doDelay(ms: Long, action: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(
        {
            action()
        },
        ms
    )
}
