package com.sungbin.sbt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.androidutils.annotation.Logging
import com.sungbin.androidutils.util.BatteryUtil
import com.sungbin.androidutils.util.Logger

@Logging
class MainActivity : AppCompatActivity() {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Logger.w("AAAAA", BatteryUtil.isIgnoringBatteryOptimization(applicationContext))
        BatteryUtil.requestIgnoreBatteryOptimization(applicationContext)
    }
}
