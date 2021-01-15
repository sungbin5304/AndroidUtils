package com.sungbin.sbt

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import me.sungbin.androidutils.annotation.Intentable

/**
 * Created by SungBin on 2021-01-16.
 */

@Intentable
class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        findViewById<Button>(R.id.btn_go_second).setOnClickListener {
            finish()
            startActivity(AutoIntent.SecondActivity(this))
        }
    }
}