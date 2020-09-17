package com.sungbin.sungbintool.util


/**
 * Created by SungBin on 2020-09-17.
 */

sealed class ToastLength {
    object SHORT: ToastLength()
    object LONG: ToastLength()
}