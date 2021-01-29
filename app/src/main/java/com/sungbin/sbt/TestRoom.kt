package com.sungbin.sbt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.sungbin.androidutils.extensions.startActivity

/**
 * Created by SungBin on 2021-01-16.
 */

class TestRoom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        startActivity<MainActivity>(false, "test" to "BBB")
    }
}
