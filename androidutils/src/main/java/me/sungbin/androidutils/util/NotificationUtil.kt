/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

@file:Suppress("DEPRECATION")

package me.sungbin.androidutils.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationManagerCompat

object NotificationUtil {

    fun createChannel(context: Context, name: String, description: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getManager(context).createNotificationChannelGroup(
                NotificationChannelGroup(
                    name,
                    name
                )
            )

            val channelMessage =
                NotificationChannel(name, name, NotificationManager.IMPORTANCE_DEFAULT)
            channelMessage.description = description
            channelMessage.group = name
            channelMessage.enableVibration(false)
            getManager(context).createNotificationChannel(channelMessage)
        }
    }

    private fun getManager(context: Context) =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNormalNotification(
        context: Context,
        id: Int,
        title: String,
        content: String,
        icon: Int,
        isOnGoing: Boolean
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val builder = Notification.Builder(context, title)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(isOnGoing)
            getManager(context).notify(id, builder.build())
        } else {
            val builder = Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(isOnGoing)
            getManager(context).notify(id, builder.build())
        }
    }

    fun showInboxStyleNotification(
        context: Context,
        id: Int,
        title: String,
        content: String,
        boxText: Array<String>,
        icon: Int,
        isOnGoing: Boolean
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val builder = Notification.Builder(context, title)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(isOnGoing)
            val inboxStyle = Notification.InboxStyle()
            inboxStyle.setBigContentTitle(title)
            inboxStyle.setSummaryText(content)

            for (element in boxText) {
                inboxStyle.addLine(element)
            }

            builder.style = inboxStyle

            getManager(context).notify(id, builder.build())
        } else {
            val builder = Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(isOnGoing)
            val inboxStyle = Notification.InboxStyle()
            inboxStyle.setBigContentTitle(title)
            inboxStyle.setSummaryText(content)

            for (str in boxText) {
                inboxStyle.addLine(str)
            }

            builder.style = inboxStyle

            getManager(context).notify(id, builder.build())
        }
    }

    fun getNormalNotification(
        context: Context,
        title: String,
        content: String,
        icon: Int,
        isOnGoing: Boolean
    ): Notification.Builder {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(context, title)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(isOnGoing)
        } else {
            Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(isOnGoing)
        }
    }

    fun getInboxStyleNotification(
        context: Context,
        title: String,
        content: String,
        boxText: Array<String>,
        icon: Int,
        isOnGoing: Boolean
    ): Notification.Builder {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val builder = Notification.Builder(context, title)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(isOnGoing)

            val inboxStyle = Notification.InboxStyle()
            inboxStyle.setBigContentTitle(title)
            inboxStyle.setSummaryText(content)

            for (string in boxText) {
                inboxStyle.addLine(string)
            }

            builder.style = inboxStyle
            builder
        } else {
            val builder = Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(isOnGoing)

            val inboxStyle = Notification.InboxStyle()
            inboxStyle.setBigContentTitle(title)
            inboxStyle.setSummaryText(content)

            for (string in boxText) {
                inboxStyle.addLine(string)
            }

            builder.style = inboxStyle
            builder
        }
    }

    fun deleteNotification(context: Context, id: Int) {
        NotificationManagerCompat.from(context).cancel(id)
    }
}
