package com.sungbin.sbt

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.sungbintool.LogUtils
import com.sungbin.sungbintool.PermissionUtils
import com.sungbin.sungbintool.ToastUtils

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val map = HashMap<String, String>()
        map["A"] = "ABC"
        map["B"] = "BCD"
        map["C"] = "CDE"
        LogUtils.d(map)

        LogUtils.d(arrayListOf("T", "E", "S", "T"))

        LogUtils.d("오!! 이쁜로그!!")

        Log.d(TAG, "일반로그")
    }
}
