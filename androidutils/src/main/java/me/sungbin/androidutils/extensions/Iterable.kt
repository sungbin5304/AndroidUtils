package me.sungbin.androidutils.extensions

/**
 * Created by SungBin on 2021-01-20.
 */

fun <T> Iterable<T>.join(separator: CharSequence) = joinTo(
    StringBuilder(),
    separator,
    "",
    "",
    -1,
    "...",
    null
).toString()
