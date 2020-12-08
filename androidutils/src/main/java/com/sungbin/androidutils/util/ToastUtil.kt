@file:Suppress("DEPRECATION")

package com.sungbin.androidutils.util

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.sungbin.androidutils.extensions.get
import com.sungbin.sungbintool.R

object ToastUtil {
    @SuppressLint("InflateParams")
    fun show(
        context: Context,
        message: String,
        duration: ToastLength,
        type: ToastType
    ) {
        val toast = Toast(context)
        val toastLayout = LayoutInflater.from(context).inflate(R.layout.layout_toast, null, false)
        val text = toastLayout[R.id.toast_text, TextView::class.java]
        val layout = toastLayout[R.id.toast_type, LinearLayout::class.java]
        val icon = layout[R.id.toast_icon, ImageView::class.java]
        text.text = message
        when (type) {
            ToastType.INFO -> {
                layout.setBackgroundResource(R.drawable.info_layout)
                icon.setImageResource(R.drawable.ic_info_outline_white_24dp)
            }
            ToastType.SUCCESS -> {
                layout.setBackgroundResource(R.drawable.success_layout)
                icon.setImageResource(R.drawable.ic_check_white_24dp)
            }
            ToastType.WARNING -> {
                layout.setBackgroundResource(R.drawable.warning_layout)
                icon.setImageResource(R.drawable.ic_pan_tool_white_24dp)
            }
            ToastType.ERROR -> {
                layout.setBackgroundResource(R.drawable.error_layout)
                icon.setImageResource(R.drawable.ic_clear_white_24dp)
            }
        }
        toast.apply {
            setDuration(if (duration == ToastLength.SHORT) Toast.LENGTH_SHORT else Toast.LENGTH_LONG)
            view = layout
        }.show()
    }
}
