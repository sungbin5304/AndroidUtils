/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

@file:Suppress("DEPRECATION")

package me.sungbin.androidutils.util

import android.os.AsyncTask
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

object DownloadUtil {

    fun download(savePath: String, downloadUrl: String, downloadDoneAction: () -> Unit = {}) {
        DownloadTask(savePath, downloadUrl, downloadDoneAction).execute()
    }

    private class DownloadTask(
        private val savePath: String,
        private val downloadUrl: String,
        private val downloadDoneAction: () -> Unit
    ) : AsyncTask<Void?, Void?, Void?>() {
        override fun doInBackground(vararg params: Void?): Void? {
            return try {
                val conn = URL(downloadUrl).openConnection() as HttpURLConnection
                val len = conn.contentLength
                val tmpByte = ByteArray(len)
                val `is` = conn.inputStream
                val fos = FileOutputStream(savePath)
                fos.buffered(2048 * 2048).use { it.write(tmpByte, 0, `is`.read(tmpByte)) }
                `is`.close()
                conn.disconnect()
                null
            } catch (exception: Exception) {
                exception.printStackTrace()
                null
            }
        }

        override fun onPostExecute(result: Void?) {
            downloadDoneAction()
            return
        }
    }
}
