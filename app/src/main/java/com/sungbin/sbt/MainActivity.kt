package com.sungbin.sbt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.androidutils.annotation.Logging

@Logging
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
