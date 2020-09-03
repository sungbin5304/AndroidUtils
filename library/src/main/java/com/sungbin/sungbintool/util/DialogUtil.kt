package com.sungbin.sungbintool.util

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import com.sungbin.sungbintool.R


object DialogUtil {
    fun show(
        ctx: Activity, title: String, message: String,
        listener: DialogInterface.OnClickListener?,
        cancelable: Boolean = true
    ) {
        val dialog = AlertDialog.Builder(ctx)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setCancelable(cancelable)
        dialog.setPositiveButton(ctx.getString(R.string.string_ok), listener)
        dialog.show()
    }

    fun showOnce(
        ctx: Activity, title: String, message: String,
        id: String, listener: DialogInterface.OnClickListener?,
        cancelable: Boolean = true
    ) {
        if (!DataUtil.readData(ctx, "$id - dialog", "false")!!.toBoolean()) {
            show(ctx, title, message, listener, cancelable)
            DataUtil.saveData(ctx, "$id - dialog", "true")
        }
    }

    fun showLicense() {
        // todo: add license interface and dialog.
    }
}