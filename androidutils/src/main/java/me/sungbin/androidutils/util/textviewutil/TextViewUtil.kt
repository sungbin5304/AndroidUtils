/*
 * Create by Sungbin Ji on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/sungbin5304/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.util.textviewutil

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import me.sungbin.androidutils.R

object TextViewUtil {
    fun setReadMore(
        type: ReadMoreType,
        view: TextView,
        text: String,
        max: Int,
        expendText: String = view.context.getString(R.string.show_more),
        expendTextColor: Int = Color.parseColor("#9E9E9E")
    ) {
        when (type) {
            ReadMoreType.LINE -> setReadMoreForLine(
                view,
                text,
                max,
                expendText,
                expendTextColor
            )
            ReadMoreType.LENGTH -> setReadMoreForLength(
                view,
                text,
                max,
                expendText,
                expendTextColor
            )
        }
    }

    private fun setReadMoreForLine(
        view: TextView,
        text: String,
        maxLine: Int,
        expendText: String,
        expendTextColor: Int
    ) {
        view.text = text
        view.post {
            if (view.lineCount >= maxLine) {
                val lineEndIndex = view.layout.getLineVisibleEnd(maxLine - 1)

                val split = text.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                var splitLength = 0

                var lessText = ""
                for (item in split) {
                    splitLength += item.length + 1
                    if (splitLength >= lineEndIndex) {
                        lessText += if (item.length >= expendText.length) {
                            item.substring(0, item.length - expendText.length) + expendText
                        } else {
                            item + expendText
                        }
                        break
                    }
                    lessText += item + "\n"
                }
                val spannableString = SpannableString(lessText)
                spannableString.setSpan(
                    object : ClickableSpan() {
                        override fun onClick(vew: View) {
                            view.text = text
                        }

                        override fun updateDrawState(ds: TextPaint) {
                            ds.color = expendTextColor
                        }
                    },
                    spannableString.length - expendText.length,
                    spannableString.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                view.text = spannableString
                view.movementMethod = LinkMovementMethod.getInstance()
            } else view.text = text
        }
    }

    private fun setReadMoreForLength(
        view: TextView,
        text: String,
        maxLength: Int,
        expendText: String,
        expendTextColor: Int
    ) {
        view.post {
            if (view.length() > maxLength) {
                val lestText = text.substring(0, maxLength) + expendText
                val spannableString = SpannableString(lestText)
                spannableString.setSpan(
                    object : ClickableSpan() {
                        override fun onClick(vew: View) {
                            view.text = text
                        }

                        override fun updateDrawState(ds: TextPaint) {
                            ds.color = expendTextColor
                        }
                    },
                    spannableString.length - expendText.length,
                    spannableString.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                view.text = spannableString
                view.movementMethod = LinkMovementMethod.getInstance()
            } else view.text = text
        }
    }
}
