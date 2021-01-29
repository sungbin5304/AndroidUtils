/*
 * Create by Sungbin Ji on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/sungbin5304/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.extensions

import android.os.Handler
import android.os.Looper

fun doDelay(ms: Long, action: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(
        {
            action()
        },
        ms
    )
}
