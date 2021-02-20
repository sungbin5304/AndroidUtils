/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.extensions

fun <T> Iterable<T>.join(separator: CharSequence) = joinTo(
    StringBuilder(),
    separator,
    "",
    "",
    -1,
    "...",
    null
).toString()
