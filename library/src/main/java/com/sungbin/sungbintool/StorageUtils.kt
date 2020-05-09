package com.sungbin.sungbintool

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Environment
import android.os.StrictMode
import android.util.Log
import android.widget.Toast
import org.jsoup.Jsoup
import java.io.*


@Suppress("DEPRECATION")
@SuppressLint("MissingPermission", "HardwareIds")
object StorageUtils {
    val sdcard = Environment.getExternalStorageDirectory().absolutePath!!

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

    fun deleteAll(name: String) {
        val dir = File(name)
        if (dir.exists() && dir.listFiles() != null) {
            for (childFile in dir.listFiles()!!) {
                if (childFile.isDirectory) {
                    deleteAll(childFile.absolutePath)
                } else {
                    childFile.delete()
                }
            }
            dir.delete()
        }
    }
}