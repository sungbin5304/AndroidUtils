package com.sungbin.sungbintool

import android.app.*
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationUtils {

    private var groupName = "undefined"
    private var actions = arrayOf<Notification.Action>()
    private var pendingIntent: PendingIntent? = null

    fun setGroupName(name: String) {
        groupName = name
    }

    fun addAction(action: Notification.Action){
        actions.plus(action)
    }

    fun setPendingIntent(pendingIntent: PendingIntent){
        this.pendingIntent = pendingIntent
    }

    fun createChannel(context: Context, name: String, description: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val group1 = NotificationChannelGroup(groupName, groupName)
            getManager(context).createNotificationChannelGroup(group1)

            val channelMessage =
                NotificationChannel(name, name, NotificationManager.IMPORTANCE_DEFAULT)
            channelMessage.description = description
            channelMessage.group = groupName
            channelMessage.enableVibration(true)
            channelMessage.vibrationPattern = longArrayOf(0, 0)
            getManager(context).createNotificationChannel(channelMessage)
        }
    }

    private fun getManager(context: Context): NotificationManager {
        return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    fun showNormalNotification(context: Context, id: Int, title: String,
                               content: String, icon: Int, isOnGoing: Boolean = false) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val builder = Notification.Builder(context, title)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setShowWhen(true)
                .setOngoing(isOnGoing)
                .setAutoCancel(true)

            for(action in actions) {
                builder.addAction(action)
            }

            if(pendingIntent != null) {
                builder.setContentIntent(pendingIntent)
            }

            getManager(context).notify(id, builder.build())
        }
        else {
            @Suppress("DEPRECATION")
            val builder = Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setAutoCancel(true)
                .setOngoing(isOnGoing)
                .setShowWhen(true)

            for(action in actions) {
                builder.addAction(action)
            }

            if(pendingIntent != null) {
                builder.setContentIntent(pendingIntent)
            }

            getManager(context).notify(id, builder.build())
        }
    }

    fun showInboxStyleNotification(context: Context, id: Int, title: String,
                                   content: String, boxText: List<String>,
                                   icon: Int, isOnGoing: Boolean = false) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val builder = Notification.Builder(context, title)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setOngoing(isOnGoing)
                .setAutoCancel(true)
            val inboxStyle = Notification.InboxStyle()
            inboxStyle.setBigContentTitle(title)
            inboxStyle.setSummaryText(content)

            for (str in boxText) {
                inboxStyle.addLine(str)
            }

            for(action in actions) {
                builder.addAction(action)
            }

            if(pendingIntent != null) {
                builder.setContentIntent(pendingIntent)
            }

            builder.style = inboxStyle
            getManager(context).notify(id, builder.build())
        }
        else {
            @Suppress("DEPRECATION")
            val builder = Notification.Builder(context)
                .setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(icon)
                .setOngoing(isOnGoing)
                .setAutoCancel(true)
            val inboxStyle = Notification.InboxStyle()
            inboxStyle.setBigContentTitle(title)
            inboxStyle.setSummaryText(content)

            for (str in boxText) {
                inboxStyle.addLine(str)
            }

            for(action in actions) {
                builder.addAction(action)
            }

            if(pendingIntent != null) {
                builder.setContentIntent(pendingIntent)
            }

            builder.style = inboxStyle
            getManager(context).notify(id, builder.build())
        }
    }

    fun deleteNotification(context: Context, id: Int) {
        try {
            NotificationManagerCompat.from(context).cancel(id)
        }
        catch (e: Exception){
            Log.e("delete notification", e.toString())
        }
    }
}
