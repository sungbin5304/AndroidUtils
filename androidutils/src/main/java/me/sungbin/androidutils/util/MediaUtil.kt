/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.util

import android.content.Context
import android.media.MediaScannerConnection
import android.media.MediaScannerConnection.MediaScannerConnectionClient
import android.net.Uri

object MediaUtil {

    fun scanning(context: Context, path: String) {
        var mediaScanner: MediaScannerConnection? = null
        val mediaScannerClient = object : MediaScannerConnectionClient {
            override fun onMediaScannerConnected() {
                mediaScanner?.scanFile(path, null)
            }

            override fun onScanCompleted(
                path: String,
                uri: Uri
            ) {
                mediaScanner?.disconnect()
            }
        }

        mediaScanner = MediaScannerConnection(context, mediaScannerClient)
        mediaScanner.connect()
    }
}
