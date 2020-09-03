@file:Suppress("DEPRECATION")

package com.sungbin.sungbintool

import android.os.AsyncTask
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

@Deprecated(
    message = "`Utils` is deprecated.\nPlease use `Util` instead of `Utils`.",
    replaceWith = ReplaceWith("DownloadUtil")
)
object DownloadUtils {

    fun download(path: String, url: String) {
        DownloadTask(path, url).execute()
    }

    private class DownloadTask constructor(
        private val path: String,
        private val url: String
    ) :
        AsyncTask<Void?, Void?, Void?>() {
        override fun doInBackground(vararg params: Void?): Void? {
            try {
                val conn = URL(url).openConnection() as HttpURLConnection
                val len = conn.contentLength
                val tmpByte = ByteArray(len)
                val `is` = conn.inputStream
                val fos = FileOutputStream(path)

                while (true) {
                    val read = `is`.read(tmpByte)
                    if (read <= 0) {
                        break
                    }
                    fos.write(tmpByte, 0, read)
                }

                `is`.close()
                fos.close()
                conn.disconnect()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }

        override fun onPostExecute(result: Void?) {
            return
        }

    }

}