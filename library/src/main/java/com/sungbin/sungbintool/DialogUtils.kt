package com.sungbin.sungbintool

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

object DialogUtils {
    fun show(ctx: Context, title: String, message: String,
             listener: DialogInterface.OnClickListener?, cancelable: Boolean = true){
        val dialog = AlertDialog.Builder(ctx)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setCancelable(cancelable)
        dialog.setPositiveButton(ctx.getString(R.string.string_ok), listener)
        dialog.show()
    }

    fun showOnce(ctx: Context, title: String, message: String,
                 id: String, listener: DialogInterface.OnClickListener?,
                 cancelable: Boolean = true){
        if(!DataUtils.readData(ctx, "$id - dialog", "false").toBoolean()){
            show(ctx, title, message, listener, cancelable)
            DataUtils.saveData(ctx, "$id - dialog", "true")
        }
    }
}