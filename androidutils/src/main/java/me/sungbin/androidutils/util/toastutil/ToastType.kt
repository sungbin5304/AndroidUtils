/*
 * Create by Sungbin Ji on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/sungbin5304/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.util.toastutil

sealed class ToastType {
    object INFO : ToastType()
    object SUCCESS : ToastType()
    object WARNING : ToastType()
    object ERROR : ToastType()
}
