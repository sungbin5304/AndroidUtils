package com.sungbin.sungbintool

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.StrictMode
import android.util.Log
import android.widget.Toast
import org.jsoup.Jsoup
import java.io.IOException

object Utils {
    private const val USER_AGENT =
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36"

    fun copy(ctx: Context, text: String) {
        val clipboard = ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", text)
        clipboard.primaryClip = clip
        ToastUtils.show(ctx, ctx.getString(R.string.copy_clipboard), ToastUtils.SHORT, ToastUtils.SUCCESS)
    }

    fun error(ctx: Context, e: Exception, at: String) {
        val data = "Error: $e\nLineNumber: ${e.stackTrace[0].lineNumber}\nAt: $at"
        ToastUtils.show(ctx, data, ToastUtils.LONG, ToastUtils.ERROR)
        copy(ctx, data)
        Log.e("Error", data)
    }

    fun getHtml(address: String): String? {
        return try {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)

            val conn = Jsoup.connect(address).userAgent(USER_AGENT)
            val doc = conn.get()
            doc.toString()
        } catch (e: IOException) {
            e.toString()
        }
    }
}