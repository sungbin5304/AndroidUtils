/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.util.licensediaog

sealed class License(val name: String) {
    object MIT : License("MIT")
    object BSD : License("BSD")
    object Apache2 : License("Apache2")
    object GPL3 : License("GPL3")
    object LGPL3 : License("LGPL3")
    object AGPL3 : License("AGPL3")
    class CUSTOM(name: String) : License(name)
}
