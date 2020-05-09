package com.sungbin.sungbintool

import android.text.Editable
import android.text.SpannableStringBuilder

object StringUtils {
    fun toEditable(string: String): Editable{
        return SpannableStringBuilder(string)
    }
}