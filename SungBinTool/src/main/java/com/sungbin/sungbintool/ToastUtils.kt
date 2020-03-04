package com.sungbin.sungbintool

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

object ToastUtils {
    const val INFO = 0
    const val SUCCESS = 1
    const val WARNING = 2
    const val ERROR = 3

    const val SHORT = 0
    const val LONG = 1

    @SuppressLint("InflateParams")
    fun show(
        context: Context,
        message: String,
        duration: Int,
        type: Int) {
        val toast = Toast(context)
        val toastLayout = LayoutInflater.from(context).inflate(R.layout.toast_layout, null, false)
        val text = toastLayout.findViewById(R.id.toast_text) as TextView
        val layout = toastLayout.findViewById(R.id.toast_type) as LinearLayout
        val icon = layout.findViewById(R.id.toast_icon) as ImageView
        text.text = message
        when (type) {
            0 -> {
                layout.setBackgroundResource(R.drawable.info_layout)
                icon.setImageResource(R.drawable.ic_info_outline_white_24dp)
            }
            1 -> {
                layout.setBackgroundResource(R.drawable.success_layout)
                icon.setImageResource(R.drawable.ic_check_white_24dp)
            }
            2 -> {
                layout.setBackgroundResource(R.drawable.warning_layout)
                icon.setImageResource(R.drawable.ic_pan_tool_white_24dp)
            }
            3 -> {
                layout.setBackgroundResource(R.drawable.error_layout)
                icon.setImageResource(R.drawable.ic_clear_white_24dp)
            }
        }
        toast.duration = if(duration == 0) Toast.LENGTH_SHORT
            else Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }
}