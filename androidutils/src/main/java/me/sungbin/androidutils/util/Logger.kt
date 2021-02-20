/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.util

import android.util.Log

object Logger {

    var TAG = "TAG"
    var showLog = true

    fun w(tag: String, any: Any?) {
        log(tag, "w", any.getLogContent())
    }

    fun v(tag: String, any: Any?) {
        log(tag, "v", any.getLogContent())
    }

    fun d(tag: String, any: Any?) {
        log(tag, "d", any.getLogContent())
    }

    fun e(tag: String, any: Any?) {
        log(tag, "e", any.getLogContent())
    }

    fun i(tag: String, any: Any?) {
        log(tag, "i", any.getLogContent())
    }

    fun w(any: Any?) {
        log(TAG, "w", any.getLogContent())
    }

    fun v(any: Any?) {
        log(TAG, "v", any.getLogContent())
    }

    fun d(any: Any?) {
        log(TAG, "d", any.getLogContent())
    }

    fun e(any: Any?) {
        log(TAG, "e", any.getLogContent())
    }

    fun i(any: Any?) {
        log(TAG, "i", any.getLogContent())
    }

    private fun log(tag: String, type: String, content: Any?) {
        if (!showLog) return
        else {
            when (type) {
                "d" -> Log.d(tag, content.toString())
                "e" -> Log.e(tag, content.toString())
                "i" -> Log.i(tag, content.toString())
                "w" -> Log.w(tag, content.toString())
                "v" -> Log.v(tag, content.toString())
                else -> Log.e(TAG, "Unavailable log type.\nAvailable log type : [d, e, i, w, v]")
            }
        }
    }

    private fun Any?.getLogContent(): String {
        var data = ""
        when (this) {
            is Iterable<*> -> {
                for ((index, element) in withIndex()) {
                    data += "\n[$index] $element"
                }
            }
            is Map<*, *> -> {
                for ((index, element) in asIterable().withIndex()) {
                    data += "\n[$index] ${element.key} - ${element.value}"
                }
            }
            is Array<*> -> {
                for ((index, element) in asIterable().withIndex()) {
                    data += "\n[$index] $element"
                }
            }
            else -> data = toString()
        }
        var logData = ""
        val splitData = data.replaceFirst("\n", "").split("\n")
        for ((index, element) in splitData.withIndex()) {
            var value = ""
            value += "\n│${"\t".repeat(5)}$element"
            if (index == splitData.size - 1) {
                value += "\n${"─".repeat(50)}"
                if (element.length >= 30) {
                    value += "─".repeat(element.length - 20)
                }
            }
            logData += value
        }
        return " $logData"
    }
}
