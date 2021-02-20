/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.extensions

import android.view.View
import androidx.annotation.IdRes

fun View.hide(isGone: Boolean = false) {
    visibility = if (isGone) View.GONE else View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

@Suppress("UNUSED_PARAMETER")
inline operator fun <reified T : View> View.get(@IdRes id: Int, clazz: Class<T>) =
    findViewById<T>(id)!!
