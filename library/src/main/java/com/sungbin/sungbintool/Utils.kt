package com.sungbin.sungbintool

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.*

object Utils {
    private var USER_AGENT =
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36"

    fun getAppVersionName(act: Activity) = act.packageManager.getPackageInfo(act.packageName, 0).versionName

    fun copy(ctx: Context, text: String, showToast: Boolean = true) {
        val clipboard = ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", text)
        clipboard.setPrimaryClip(clip)
        if (showToast) ToastUtils.show(
            ctx,
            ctx.getString(R.string.copy_clipboard),
            ToastUtils.SHORT,
            ToastUtils.SUCCESS
        )
    }

    fun error(ctx: Context, e: Exception, at: String) {
        val data = "Error: $e\nLineNumber: ${e.stackTrace[0].lineNumber}\nAt: $at"
        ToastUtils.show(ctx, data, ToastUtils.LONG, ToastUtils.ERROR)
        copy(ctx, data)
        Log.e("Error", data)
    }

    fun setUserAgent(agent: String) {
        USER_AGENT = agent
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
                var str = br.readLine()
                var line: String? = ""
                while ({ line = br.readLine(); line }() != null) {
                    str += "\n" + line
                }
                br.close()
                isr.close()
                return str
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