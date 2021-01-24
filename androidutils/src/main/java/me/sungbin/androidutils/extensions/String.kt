package me.sungbin.androidutils.extensions

import android.text.SpannableStringBuilder
import java.util.regex.Pattern

/**
 * Created by SungBin on 2021-01-20.
 */

fun String.replaceLast(findText: String, replaceText: String): String {
    return if (contains(findText)) {
        val lastIndex = lastIndexOf(findText)
        val string = substring(0, lastIndex)
        val string2 = substring((lastIndex + findText.length), this.length)
        string + replaceText + string2
    } else this
}

fun String.isUpperCase() = Pattern.matches("[A-Z]*$", this)

fun String.isLowerCase() = Pattern.matches("[a-z]*$", this)

fun String?.toEditable() = SpannableStringBuilder(this ?: "")
