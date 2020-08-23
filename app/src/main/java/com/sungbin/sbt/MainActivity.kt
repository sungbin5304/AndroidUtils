package com.sungbin.sbt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.sungbintool.LogUtils
import com.sungbin.sungbintool.extensions.afterTextChanged
import com.sungbin.sungbintool.extensions.clear
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      LogUtils.d(arrayOf("test", "test2", "test3"))
    }
}
