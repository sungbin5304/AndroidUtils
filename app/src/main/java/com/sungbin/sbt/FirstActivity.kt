package com.sungbin.sbt

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import me.sungbin.androidutils.annotation.Intentable
import me.sungbin.androidutils.extensions.alert
import me.sungbin.androidutils.extensions.toast
import me.sungbin.androidutils.util.DialogUtil
import me.sungbin.androidutils.util.licensediaog.License
import me.sungbin.androidutils.util.licensediaog.Project
import me.sungbin.androidutils.util.toastutil.ToastLength
import me.sungbin.androidutils.util.toastutil.ToastType

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

        toast("AAA", ToastLength.SHORT, ToastType.SUCCESS)
        alert(null, "AAAA", "BBB") { _, _ ->
            toast("BBBBB", ToastLength.SHORT, ToastType.SUCCESS)
        }

        val custonLicense = License.CUSTOM("AA")

        DialogUtil.showLicense(
            this,
            "제발성공",
            arrayOf(
                Project("TEST", "naver.com", custonLicense),
                Project("TES154T", "naver.com", custonLicense),
                Project("TEST123", "naver.com", custonLicense),
                Project("AndroidUtils", "https://github.com/sungbin5304/AndroidUtils", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT),
                Project("TEST2", "naver.com", License.MIT)
            )
        )
    }
}
