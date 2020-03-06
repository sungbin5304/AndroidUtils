package com.sungbin.sungbintool

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtils {
    fun request(act: Activity, message: String, permission: Array<String>){
        DialogUtils.show(act, "권한 필요", message, DialogInterface.OnClickListener { _, _ ->
            ActivityCompat.requestPermissions(act, permission, 1);
        })
    }
}