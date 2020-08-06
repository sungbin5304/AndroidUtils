package com.sungbin.sungbintool

import android.annotation.SuppressLint
import android.os.Environment
import java.io.*
import java.text.DecimalFormat
import kotlin.math.log10
import kotlin.math.pow


@Suppress("DEPRECATION")
@SuppressLint("MissingPermission", "HardwareIds")
object StorageUtils {
    val sdcard = Environment.getExternalStorageDirectory().absolutePath

    fun createFolder(name: String) = File("$sdcard/$name").mkdirs()

    fun getSize(size: Long): String {
        if (size <= 0) return "0"
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val digitGroups = (log10(size.toDouble()) / log10(1000.0)).toInt()
        return DecimalFormat("#,##0.#").format(
            size / 1000.0.pow(digitGroups.toDouble())
        ).toString() + " " + units[digitGroups]
    }

    fun getFileSize(file: File) = getSize(file.length())

    fun read(name: String, _null: String?): String? {
        return try {
            val file = File("$sdcard/$name")
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
            if (str == null) {
                _null
            } else {
                str + ""
            }
        }
        catch (e: Exception){
            _null
        }
    }

    fun save(name: String, content: String): Boolean {
        return try {
            val file = File("$sdcard/$name")
            val fos = FileOutputStream(file)
            fos.write(content.toByteArray())
            fos.close()
            true
        } catch (e: Exception){
            false
        }
    }

    fun delete(name: String) = File("$sdcard/$name").delete()

    fun deleteAll(name: String): Boolean {
        return try {
            val dir = File("$sdcard/$name")
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
            true
        }
        catch (e: Exception){
            false
        }
    }
}