/*
 * Create by Sungbin Ji on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/sungbin5304/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.extensions

import android.widget.ImageView
import androidx.core.widget.ImageViewCompat

fun ImageView.setTint(color: Int) = ImageViewCompat.setImageTintList(
    this, color.toColorStateList()
)
