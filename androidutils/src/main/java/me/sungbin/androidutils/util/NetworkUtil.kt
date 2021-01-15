package me.sungbin.androidutils.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.TYPE_WIFI
import android.net.NetworkCapabilities
import android.os.Build

object NetworkUtil {
    @Suppress("DEPRECATION")
    fun isNetworkAvailable(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getNetworkCapabilities(activeNetwork)?.run {
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                            || hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                            || hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                } ?: false
            } else {
                val activeNetworkInfo = activeNetworkInfo
                if (activeNetworkInfo != null) {
                    val type = activeNetworkInfo.type
                    if (type == ConnectivityManager.TYPE_MOBILE) {
                        return true
                    } else if (type == TYPE_WIFI) {
                        return true
                    }
                }
                return false
            }
        }
}