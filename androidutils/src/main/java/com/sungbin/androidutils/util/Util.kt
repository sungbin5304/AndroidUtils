package com.sungbin.androidutils.util

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.StrictMode
import android.util.Log
import android.util.TypedValue
import com.sungbin.sungbintool.R
import java.io.InputStreamReader
import java.net.URL
import java.util.*

object Util {

    fun dp2px(context: Context, dp: Float) =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)

    fun getAppVersionName(act: Activity) =
        act.packageManager.getPackageInfo(act.packageName, 0).versionName

    fun copy(context: Context, text: String, showToast: Boolean = true) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("label", text))
        if (showToast) ToastUtil.show(
            context,
            context.getString(R.string.copy_clipboard),
            ToastLength.SHORT,
            ToastType.SUCCESS
        )
    }

    fun error(ctx: Context, e: Exception, at: String) {
        val data = "Error: $e\nLineNumber: ${e.stackTrace[0].lineNumber}\nAt: $at"
        ToastUtil.show(ctx, data, ToastLength.LONG, ToastType.ERROR)
        copy(ctx, data)
        Log.e("Error", data)
    }

    fun getHtml(address: String, userAgent: String? = null): String? {
        return try {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val url = URL(address)
            val con = url.openConnection()
            con?.let {
                con.connectTimeout = 5000
                if (userAgent != null) con.addRequestProperty("User-Agent", userAgent)
                con.useCaches = false
                val isr = InputStreamReader(con.getInputStream())
                return isr.buffered(1024 * 1024).use { it.readText() }
            }
            null
        } catch (ignored: Exception) {
            null
        }
    }

    fun readAssets(context: Context, name: String): String {
        val assetManager = context.assets
        val inputStream = assetManager.open(name)
        return inputStream.bufferedReader().use { it.readText() }
    }

    fun makeRandomUUID() = UUID.randomUUID().toString()
}