/*
 * Create by Sungbin Ji on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/sungbin5304/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker
import me.sungbin.androidutils.R

object PermissionUtil {

    fun request(
        activity: Activity,
        message: String?,
        permissions: Array<String>,
        requestCode: Int = 1
    ) {
        if (!checkPermissionsAllGrant(activity, permissions)) {
            if (message.isNullOrBlank()) {
                ActivityCompat.requestPermissions(activity, permissions, requestCode)
            } else {
                DialogUtil.show(
                    activity,
                    activity.getString(R.string.need_permission),
                    message,
                    { _, _ ->
                        ActivityCompat.requestPermissions(activity, permissions, requestCode)
                    }
                )
            }
        }
    }

    fun requestReadNotification(activity: Activity) {
        val intent = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
        activity.startActivity(intent)
    }

    fun checkPermissionsAllGrant(context: Context, permissions: Array<String>): Boolean {
        var isAllGrant = true
        permissions.forEach {
            if (PermissionChecker.checkSelfPermission(
                    context,
                    it
                ) == PermissionChecker.PERMISSION_DENIED
            ) {
                isAllGrant = false
                return@forEach
            }
        }
        return isAllGrant
    }
}
