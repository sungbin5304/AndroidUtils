package me.sungbin.androidutils.util

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import me.sungbin.sungbintool.R

object DialogUtil {
    fun show(
        activity: Activity, title: String, message: String,
        listener: DialogInterface.OnClickListener?,
        cancelable: Boolean = true
    ) {
        val dialog = AlertDialog.Builder(activity)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setCancelable(cancelable)
        dialog.setPositiveButton(activity.getString(R.string.string_ok), listener)
        dialog.show()
    }

    fun showOnce(
        activity: Activity, title: String, message: String,
        id: String, listener: DialogInterface.OnClickListener?,
        cancelable: Boolean = true
    ) {
        if (!DataUtil.readData(activity, "$id - dialog", "false")!!.toBoolean()) {
            show(activity, title, message, listener, cancelable)
            DataUtil.saveData(activity, "$id - dialog", "true")
        }
    }

    fun showLicense() {
        // todo: add license interface and dialog.
    }
}