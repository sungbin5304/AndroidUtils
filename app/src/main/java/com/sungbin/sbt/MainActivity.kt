package com.sungbin.sbt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.sungbintool.util.ToastLength
import com.sungbin.sungbintool.util.ToastType
import com.sungbin.sungbintool.util.ToastUtil
import com.sungbin.sungbintool.util.Util.doDelay

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doDelay({
            ToastUtil.show(applicationContext, "TEST", ToastLength.LONG, ToastType.SUCCESS)
        }, 1500)
    }
}
