package com.sungbin.sungbintool

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Environment
import android.os.StrictMode
import android.util.Log
import com.shashank.sony.fancytoastlib.FancyToast
import org.jsoup.Jsoup
import java.io.*


@Suppress("DEPRECATION")
@SuppressLint("MissingPermission", "HardwareIds")
object Utils {
    val sdcard = Environment.getExternalStorageDirectory().absolutePath!!
    private const val USER_AGENT =
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36"

    fun createFolder(name: String) {
        File("$sdcard/$name/").mkdirs()
    }

    fun read(name: String, _null: String): String {
        try {
            val file = File("$sdcard/$name/")
            if (!file.exists()) return _null
            val fis = FileInputStream(file)
            val isr = InputStreamReader(fis)
            val br = BufferedReader(isr)
            var str = br.readLine()

            while (true) {
                val inputLine = br.readLine() ?: break
                str += "\n" + inputLine
            }
            fis.close()
            isr.close()
            br.close()
            return str.toString()
        } catch (e: Exception) {
            Log.e("READ", e.toString())
        }

        return _null
    }

    fun save(name: String, content: String) {
        try {
            val file = File("$sdcard/$name")
            val fos = FileOutputStream(file)
            fos.write(content.toByteArray())
            fos.close()
        } catch (e: Exception) {
            Log.e("SAVE", e.toString())
        }

    }

    fun delete(name: String) {
        File("$sdcard/$name").delete()
    }

    fun readData(ctx: Context, name: String, _null: String): String? {
        val pref = ctx.getSharedPreferences("pref", MODE_PRIVATE)
        return pref.getString(name, _null)
    }

    fun saveData(ctx: Context, name: String, value: String) {
        val pref = ctx.getSharedPreferences("pref", MODE_PRIVATE)
        val editor = pref.edit()

        editor.putString(name, value)
        editor.apply()
    }

    fun clearData(ctx: Context) {
        val pref = ctx.getSharedPreferences("pref", MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.apply()
    }

    fun copy(ctx: Context, text: String) {
        val clipboard = ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", text)
        clipboard.primaryClip = clip
        toast(ctx, "클립보드에 복사되었습니다.", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS)
    }

    fun error(ctx: Context, e: Exception, at: String) {
        val data = "Error: $e\nLineNumber: ${e.stackTrace[0].lineNumber}\nAt: $at"
        toast(ctx, data, FancyToast.LENGTH_SHORT, FancyToast.ERROR)
        copy(ctx, data)
        Log.e("Error", data)
    }

    @JvmStatic
    fun toast(ctx: Context, txt: String, length: Int, type: Int) {
        FancyToast.makeText(ctx, txt, length, type, false).show()
    }

    fun getHtml(adress: String): String? {
        return try {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)

            val conn = Jsoup.connect(adress).userAgent(USER_AGENT)
            val doc = conn.get()
            doc.toString()
        } catch (e: IOException) {
            null
        }

    }
}