package me.sungbin.androidutils.extensions

import android.view.View
import androidx.annotation.IdRes

/**
 * Created by SungBin on 2021-01-20.
 */

fun View.hide(isGone: Boolean = false) {
    visibility = if (isGone) View.GONE else View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

@Suppress("UNUSED_PARAMETER")
inline operator fun <reified T : View> View.get(@IdRes id: Int, clazz: Class<T>) =
    findViewById<T>(id)!!
