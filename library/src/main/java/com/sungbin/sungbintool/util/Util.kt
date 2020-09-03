package com.sungbin.sungbintool.util

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import com.sungbin.sungbintool.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.*

object Util {
    fun getAppVersionName(act: Activity) =
        act.packageManager.getPackageInfo(act.packageName, 0).versionName

    fun copy(context: Context, text: String, showToast: Boolean = true) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("label", text))
        if (showToast) ToastUtil.show(
            context,
            context.getString(R.string.copy_clipboard),
            ToastUtil.SHORT,
            ToastUtil.SUCCESS
        )
    }

    fun error(ctx: Context, e: Exception, at: String) {
        val data = "Error: $e\nLineNumber: ${e.stackTrace[0].lineNumber}\nAt: $at"
        ToastUtil.show(ctx, data, ToastUtil.LONG, ToastUtil.ERROR)
        copy(ctx, data)
        Log.e("Error", data)
    }

    fun getHtml(address: String): String? {
        return try {
            val url = URL(address)
            val con = url.openConnection()
            if (con != null) {
                con.connectTimeout = 5000
                con.useCaches = false
                val isr = InputStreamReader(con.getInputStream())
                val br = BufferedReader(isr)
                var string = br.readLine()
                br.readLine()?.let {
                    string += "\n$it"
                }
                br.close()
                isr.close()
                return string
            }
            null
        } catch (e: Exception) {
            null
        }
    }

    fun makeRandomUUID(onlyNumber: Boolean = true) = UUID.randomUUID().toString().apply {
        if (onlyNumber) replace("-", "")
    }
}