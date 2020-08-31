package com.sungbin.sbt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.sungbintool.LogUtils
import com.sungbin.sungbintool.extensions.replaceLast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      LogUtils.d("안녕녕녕녕녕녕녕".replaceLast("녕", "!"))
    }
}
