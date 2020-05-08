package com.sungbin.sungbintool

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat

object ReadMoreUtils {
    fun setReadMoreLine(view: TextView, text: String, maxLine: Int,
                        expanedText: String = "...더보기",
                        expanedTextColor: Int = Color.parseColor("#9E9E9E")) {
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
                        lessText += if (item.length >= expanedText.length) {
                            item.substring(0, item.length - expanedText.length) + expanedText
                        } else {
                            item + expanedText
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
                            ds.color = expanedTextColor
                        }
                    },
                    spannableString.length - expanedText.length,
                    spannableString.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                view.text = spannableString
                view.movementMethod = LinkMovementMethod.getInstance()
            } else view.text = text
        }
    }

    fun setReadMoreLength(view: TextView, text: String, maxLength: Int,
                          expanedText: String = "...더보기",
                          expanedTextColor: Int = Color.parseColor("#9E9E9E")) {
        view.post {
            if (view.length() > maxLength) {
                val lestText = text.substring(0, maxLength) + expanedText
                val spannableString = SpannableString(lestText)
                spannableString.setSpan(
                    object : ClickableSpan() {
                        override fun onClick(vew: View) {
                            view.text = text
                        }

                        override fun updateDrawState(ds: TextPaint) {
                            ds.color = expanedTextColor
                        }
                    },
                    spannableString.length - expanedText.length,
                    spannableString.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                view.text = spannableString
                view.movementMethod = LinkMovementMethod.getInstance()
            } else view.text = text
        }
    }
}