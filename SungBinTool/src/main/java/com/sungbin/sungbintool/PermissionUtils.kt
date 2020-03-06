package com.sungbin.sungbintool

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.core.app.ActivityCompat


object PermissionUtils {
    fun request(act: Activity, message: String, permission: Array<String>){
        DialogUtils.show(act, "권한 필요", message, DialogInterface.OnClickListener { _, _ ->
            ActivityCompat.requestPermissions(act, permission, 1);
        })
    }

    fun requestReadNotification(act: Activity){
        val intent = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
        act.startActivity(intent)
    }
}