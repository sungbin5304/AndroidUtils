package com.sungbin.sungbintool

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


object PermissionUtils {
    fun request(act: Activity, message: String, permission: Array<String>){
        var isShowDialog = false
        for(element in permission){
            if(ContextCompat.checkSelfPermission(act, element) == PackageManager.PERMISSION_DENIED){
                isShowDialog = true
            }
        }
        if(isShowDialog) {
            DialogUtils.show(act, "권한 필요", message, DialogInterface.OnClickListener { _, _ ->
                ActivityCompat.requestPermissions(act, permission, 1);
            })
        }
    }

    fun requestReadNotification(act: Activity){
        val intent = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
        act.startActivity(intent)
    }
}