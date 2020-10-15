package com.sungbin.sbt

import android.app.Application
import com.sungbin.sungbintool.tool.CrashReporter


/**
 * Created by SungBin on 2020-10-15.
 */

class SBT : Application() {

    override fun onCreate() {
        super.onCreate()
        CrashReporter.init(applicationContext)
    }

}