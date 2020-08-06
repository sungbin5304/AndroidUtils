package com.sungbin.sungbintool

import android.text.SpannableStringBuilder

object StringUtils {
    fun toEditable(string: String) = SpannableStringBuilder(string)
}