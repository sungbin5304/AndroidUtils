package com.sungbin.sbt.second.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.sbt.AutoIntent
import com.sungbin.sbt.R
import me.sungbin.androidutils.annotation.Intentable

/**
 * Created by SungBin on 2021-01-16.
 */

@Intentable
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.btn_go_first).setOnClickListener {
            finish()
            startActivity(AutoIntent.FirstActivity(this))
        }
    }
}