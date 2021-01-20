package me.sungbin.androidutils.extensions

import android.view.View
import androidx.annotation.IdRes

/**
 * Created by SungBin on 2021-01-20.
 */

fun View.hide(isGone: Boolean = false) {
    this.visibility = if (isGone) View.GONE else View.INVISIBLE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

operator fun <T : View> View.get(@IdRes id: Int, clazz: Class<T>) = this.findViewById<T>(id)!!
