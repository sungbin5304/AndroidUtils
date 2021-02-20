/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.extensions

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.fragment.app.Fragment
import me.sungbin.androidutils.util.toastutil.ToastLength
import me.sungbin.androidutils.util.toastutil.ToastType
import me.sungbin.androidutils.util.toastutil.ToastUtil
import java.io.Serializable

@Throws(Exception::class)
inline fun <reified T> Fragment.startActivity(
    isNewTask: Boolean = false,
    vararg extras: Pair<String, *>
) {
    requireActivity().startActivity(
        Intent(requireActivity(), T::class.java).apply {
            if (isNewTask) addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            extras.iterator().forEach {
                when (it.second) {
                    is Int -> putExtra(it.first, it.second as Int)
                    is Long -> putExtra(it.first, it.second as Long)
                    is Char -> putExtra(it.first, it.second as Char)
                    is Byte -> putExtra(it.first, it.second as Byte)
                    is Short -> putExtra(it.first, it.second as Short)
                    is Float -> putExtra(it.first, it.second as Float)
                    is Double -> putExtra(it.first, it.second as Double)
                    is Boolean -> putExtra(it.first, it.second as Boolean)
                    is String? -> putExtra(it.first, it.second as String?)
                    is Bundle? -> putExtra(it.first, it.second as Bundle?)
                    is IntArray? -> putExtra(it.first, it.second as IntArray?)
                    is CharArray? -> putExtra(it.first, it.second as CharArray?)
                    is LongArray? -> putExtra(it.first, it.second as LongArray?)
                    is ByteArray? -> putExtra(it.first, it.second as ByteArray?)
                    is ShortArray? -> putExtra(it.first, it.second as ShortArray?)
                    is Parcelable? -> putExtra(it.first, it.second as Parcelable?)
                    is FloatArray? -> putExtra(it.first, it.second as FloatArray?)
                    is DoubleArray? -> putExtra(it.first, it.second as DoubleArray?)
                    is CharSequence? -> putExtra(it.first, it.second as CharSequence?)
                    is Serializable? -> putExtra(it.first, it.second as Serializable?)
                    is BooleanArray? -> putExtra(it.first, it.second as BooleanArray?)
                    else -> throw Exception("${it.first} pair second value(${it.second}) is not supported type.")
                }
            }
        }
    )
}

fun Fragment.alert(
    title: String?,
    message: String = "",
    closeMessage: String = "",
    closeEvent: ((DialogInterface, Int) -> Unit)? = null
) = requireActivity().alert(title, message, closeMessage, closeEvent)

@Suppress("DEPRECATION")
@Deprecated(
    "Custom Toast was Deprecated at Android R",
    ReplaceWith(
        "toast(message)",
        "me.sungbin.androidutils.util.toastutil.ToastUtil"
    )
)
fun Fragment.toast(message: String, duration: ToastLength = ToastLength.SHORT, type: ToastType) =
    ToastUtil.show(requireContext(), message, duration, type)

fun Fragment.toast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) = ToastUtil.show(requireContext(), message, duration)
