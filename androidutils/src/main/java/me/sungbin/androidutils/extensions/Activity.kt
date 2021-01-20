package me.sungbin.androidutils.extensions

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import me.sungbin.androidutils.util.toastutil.ToastLength
import me.sungbin.androidutils.util.toastutil.ToastType
import me.sungbin.androidutils.util.toastutil.ToastUtil

/**
 * Created by SungBin on 2021-01-20.
 */

fun Activity.alert(
    title: String?,
    message: String,
    closeMessage: String = "",
    closeEvent: ((DialogInterface, Int) -> Unit)? = null
) {
    val dialog = AlertDialog.Builder(this)
        .setMessage(message)
        .setPositiveButton(closeMessage) { dialogInterface: DialogInterface, i: Int ->
            closeEvent?.invoke(dialogInterface, i)
        }
    if (title?.isNotEmpty() == true) dialog.setTitle(title)
    dialog.show()
}

fun Activity.toast(message: String, duration: ToastLength = ToastLength.SHORT, type: ToastType) =
    ToastUtil.show(this, message, duration, type)
