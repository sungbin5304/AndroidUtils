package com.sungbin.sbt

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.sungbintool.PermissionUtils
import com.sungbin.sungbintool.ToastUtils

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
