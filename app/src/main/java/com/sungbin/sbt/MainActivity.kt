package com.sungbin.sbt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.sungbin.androidutils.util.DialogUtil
import me.sungbin.androidutils.util.licensediaog.License
import me.sungbin.androidutils.util.licensediaog.Project

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DialogUtil.showLicense(
            this, "AAA",
            listOf(
                Project("1", "bb", License.Apache2),
                Project("2", "bb", License.Apache2),
                Project("3", "bb", License.MIT),
                Project("4", "bb", License.MIT),
                Project("5", "bb", License.Apache2),
                Project("6", "bb", License.BSD),
                Project("9", "bb", License.BSD),
                Project("10", "bb", License.BSD),
                Project("7", "bb", License.Apache2),
                Project("8", "bb", License.Apache2),
            )
        )
    }
}
