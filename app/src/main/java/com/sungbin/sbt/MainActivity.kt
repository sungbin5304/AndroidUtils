package com.sungbin.sbt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.androidutils.util.Util
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et.updateRadius(Util.dp2px(applicationContext, 15f).toInt())
    }

}
