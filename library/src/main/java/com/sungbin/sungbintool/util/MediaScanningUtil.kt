package com.sungbin.sungbintool.util

import android.content.Context
import android.media.MediaScannerConnection
import android.media.MediaScannerConnection.MediaScannerConnectionClient
import android.net.Uri

object MediaScanningUtil {

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