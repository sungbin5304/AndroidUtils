package com.sungbin.sungbintool

import android.util.Log

object LogUtils {
    var TAG = "TAG"
    private var showLog = true

    fun setTag(tag: String){
        this.TAG = tag
    }

    fun showLog(showLog: Boolean){
        this.showLog = showLog
    }

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

    fun log(tag: String, type: String, content: Any?){
        if(!showLog) return
        else {
            when(type){
                "d" -> Log.d(tag, content.toString())
                "e" -> Log.e(tag, content.toString())
                "i" -> Log.i(tag, content.toString())
                "w" -> Log.w(tag, content.toString())
                "v" -> Log.v(tag, content.toString())
                else -> Log.e(TAG, "Unavailable log type.\nAvailable log type : [d, e, i, w, v]")
            }
        }
    }

    private fun Any?.getLogContent(): String{
        var data: String
        when(this) {
            is Iterable<*> -> {
                data = ""
                for((index, element) in this.withIndex()){
                    data += "\n[$index] $element"
                }
            }
            is Map<*, *> -> {
                data = ""
                for((index, element) in this.asIterable().withIndex()){
                    data += "\n[$index] ${element.key} - ${element.value}"
                }
            }
            else -> data = this.toString()
        }
        var logData = ""
        val splitData = data.replaceFirst("\n", "").split("\n")
        for((index, element) in splitData.withIndex()){
            var value = ""
            value += "\n│${"\t".repeat(5)}$element"
            if(index == splitData.size - 1){
                value += "\n${"─".repeat(50)}"
            }
            logData += value
        }
        return " $logData"
    }

}