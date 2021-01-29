/*
 * Create by Sungbin Ji on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/sungbin5304/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.extensions

import android.text.SpannableStringBuilder
import java.util.regex.Pattern

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
