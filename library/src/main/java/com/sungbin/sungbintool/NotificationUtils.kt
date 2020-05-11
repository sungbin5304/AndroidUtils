package com.sungbin.sungbintool

import android.app.*
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationUtils {

    /**
     * Created by SungBin on 2018. 01. 07.
     */

    private var GROUP_NAME = "undefined"

    fun setGroupName(name: String) {
        GROUP_NAME = name
    }

    fun createChannel(context: Context, name: String, description: String) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val group1 = NotificationChannelGroup(GROUP_NAME, GROUP_NAME)
            getManager(context).createNotificationChannelGroup(group1)

            val channelMessage =
                NotificationChannel(Channel.NAME, name, android.app.NotificationManager.IMPORTANCE_DEFAULT)
            channelMessage.description = description
            channelMessage.group = GROUP_NAME
            //channelMessage.lightColor = R.color.colorAccent
            channelMessage.enableVibration(true)
            channelMessage.vibrationPattern = longArrayOf(0, 0)
            getManager(context).createNotificationChannel(channelMessage)
        }
    }

    private fun getManager(context: Context): android.app.NotificationManager {
        return context.getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager
    }

    fun showNormalNotification(context: Context, id: Int, title: String,
                               content: String, icon: Int) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val builder = Notification.Builder(context, Channel.NAME)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(true)
            getManager(context).notify(id, builder.build())
        } else {
            val builder = Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(true)
            getManager(context).notify(id, builder.build())
        }
    }

    fun showInboxStyleNotification(context: Context, id: Int,
                                   title: String, content: String,
                                   boxText: Array<String>, icon: Int) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val builder = Notification.Builder(context, Channel.NAME)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(true)
            val inboxStyle = Notification.InboxStyle()
            inboxStyle.setBigContentTitle(title)
            inboxStyle.setSummaryText(content)

            for (str in boxText) {
                inboxStyle.addLine(str)
            }

            builder.style = inboxStyle

            getManager(context).notify(id, builder.build())
        } else {
            val builder = Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(true)
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

    fun deleteNotification(context: Context, id: Int) {
        NotificationManagerCompat.from(context).cancel(id)
    }

    annotation class Channel {
        companion object {
            const val NAME = "CHANNEL"
        }
    }

}
