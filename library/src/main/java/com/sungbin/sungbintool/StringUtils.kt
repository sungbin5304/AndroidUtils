package com.sungbin.sungbintool

import android.text.SpannableStringBuilder

@Deprecated(
    message = "`StringUtils` is deprecated.\nPlease use `String.toEditable()` instead of `StringUtils`."
)
object StringUtils {
    fun toEditable(string: String?) = SpannableStringBuilder(string.toString())
}