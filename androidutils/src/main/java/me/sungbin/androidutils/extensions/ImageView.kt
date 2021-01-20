package me.sungbin.androidutils.extensions

import android.widget.ImageView
import androidx.core.widget.ImageViewCompat

/**
 * Created by SungBin on 2021-01-20.
 */

fun ImageView.setTint(color: Int) = ImageViewCompat.setImageTintList(
    this, color.toColorStateList()
)
