package com.sungbin.sbt

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.androidutils.annotation.ContextChecker
import com.sungbin.androidutils.annotation.ContextType
import com.sungbin.androidutils.annotation.Logging
import com.sungbin.androidutils.util.Logger
import me.sungbin.androidutils.annotation.GreetingGenerator

@Logging
class MainActivity : AppCompatActivity() {

    @GreetingGenerator
    class Santa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkContextType(applicationContext)
        println(Generated_Santa().greeting())
    }

    private fun checkContextType(@ContextChecker(ContextType.APPLICATION) context: Context) {
        Logger.w(context is Application)
    }
}
