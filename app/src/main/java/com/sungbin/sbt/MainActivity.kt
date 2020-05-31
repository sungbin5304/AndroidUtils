package com.sungbin.sbt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.sungbintool.LogUtils

class MainActivity : AppCompatActivity() {

    private val TAG = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val map = HashMap<String, String>()
        map["A"] = "BCD"
        map["E"] = "FGH"
        map["I"] = "JKL"
        LogUtils.d("Map Content", map)
        LogUtils.i("Iterable Content", arrayListOf("T", "", "E", "", "S", "T", "", "above data is empty value."))
        LogUtils.e(null)
        LogUtils.w("This is my Pretty Log.")
        LogUtils.setTag("Custom Tag")
        LogUtils.v("Change Tag.")*/

        LogUtils.d("\uD83C\uDF08 This is Pretty Logger for Android Studio! \uD83C\uDF89\n\nPretty Logger can download at AndroidUtils.")
    }
}
