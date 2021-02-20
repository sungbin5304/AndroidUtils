/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.util.Log
import android.util.TypedValue
import me.sungbin.androidutils.util.toastutil.ToastUtil
import me.sungbin.sungbintool.R
import java.io.InputStreamReader
import java.net.URL
import java.util.UUID

object Util {

    fun dp2px(context: Context, dp: Float) =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)

    fun getAppVersionName(context: Context) =
        context.packageManager.getPackageInfo(context.packageName, 0).versionName

    fun getAppVersionCode(context: Context) =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            context.packageManager.getPackageInfo(context.packageName, 0).longVersionCode
        } else {
            @Suppress("DEPRECATION")
            context.packageManager.getPackageInfo(context.packageName, 0).versionCode
        }

    fun copy(context: Context, text: String, showToast: Boolean = true) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("label", text))
        if (showToast) ToastUtil.show(
            context,
            context.getString(R.string.copy_clipboard)
        )
    }

    fun error(context: Context, e: Exception, at: String) {
        val data = "Error: $e\nLineNumber: ${e.stackTrace[0].lineNumber}\nAt: $at"
        ToastUtil.show(context, data)
        copy(context, data)
        Log.e("Error", data)
    }

    @Throws(Exception::class)
    fun getHtml(address: String, userAgent: String? = null): String? {
        return try {
            val url = URL(address)
            val con = url.openConnection()
            con?.let {
                con.connectTimeout = 5000
                if (userAgent != null) con.addRequestProperty("User-Agent", userAgent)
                con.useCaches = false
                val isr = InputStreamReader(con.getInputStream())
                return isr.buffered(2048 * 2048).use { it.readText() }
            }
            null
        } catch (exception: Exception) {
            throw exception
        }
    }

    fun readAsset(context: Context, name: String): String {
        val assetManager = context.assets
        val inputStream = assetManager.open(name)
        return inputStream.bufferedReader().use { it.readText() }
    }

    fun makeRandomUUID() = UUID.randomUUID().toString()
}
