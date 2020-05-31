package com.sungbin.sbt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.sungbintool.LogUtils

class MainActivity : AppCompatActivity() {

    private val TAG = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val map = HashMap<String, String>()
        map["A"] = "ABC"
        map["B"] = "BCD"
        map["C"] = "CDE"
        map["D"] = ""
        LogUtils.d(map)

        LogUtils.d("ArrayList", arrayListOf("T", "", "E", "", "S", "T", ""))

        LogUtils.e(null)

        LogUtils.d("This is my Pretty Log.")
    }
}
