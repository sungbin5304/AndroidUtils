/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.util.toastutil

sealed class ToastType {
    object INFO : ToastType()
    object SUCCESS : ToastType()
    object WARNING : ToastType()
    object ERROR : ToastType()
}
