package com.sungbin.androidutils.util


/**
 * Created by SungBin on 2020-09-17.
 */

sealed class ToastType {
    object INFO: ToastType()
    object SUCCESS: ToastType()
    object WARNING: ToastType()
    object ERROR: ToastType()
}