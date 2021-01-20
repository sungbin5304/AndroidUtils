package me.sungbin.androidutils.util.toastutil

/**
 * Created by SungBin on 2020-09-17.
 */

sealed class ToastLength {
    object SHORT : ToastLength()
    object LONG : ToastLength()
}
