package me.sungbin.androidutils.extensions

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.RequiresApi

/**
 * Created by SungBin on 2021-01-20.
 */

@RequiresApi(Build.VERSION_CODES.M)
fun Icon.toBitmap(context: Context) = (loadDrawable(context) as BitmapDrawable).bitmap
