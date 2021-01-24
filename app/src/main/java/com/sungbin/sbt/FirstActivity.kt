package com.sungbin.sbt

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import me.sungbin.androidutils.annotation.Intentable
import me.sungbin.androidutils.extensions.get
import me.sungbin.androidutils.util.DialogUtil
import me.sungbin.androidutils.util.licensediaog.License
import me.sungbin.androidutils.util.licensediaog.Project

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

        val layout = layoutInflater.inflate(R.layout.activity_first, LinearLayout(this))
        val test = layout[R.id.btn_go_second, Button::class.java]

        DialogUtil.showLicense(
            this,
            "오픈소스 라이선스",
            arrayOf(
                Project("kotlin", "https://github.com/JetBrains/kotlin", License.Apache2),
                Project(
                    "androidx",
                    "https://github.com/androidx/androidx",
                    License.Apache2
                ),
                Project(
                    "AndroidStudio Icon Assets",
                    "http://www.apache.org/licenses/LICENSE-2.0.txt",
                    License.Apache2
                ),
                Project(
                    "SmoothBottomBar",
                    "https://github.com/ibrahimsn98/SmoothBottomBar",
                    License.MIT
                ),
                Project(
                    "lottie-android",
                    "https://github.com/airbnb/lottie-android",
                    License.Apache2
                ),
                Project(
                    "material-components-android",
                    "https://github.com/material-components/material-components-android",
                    License.Apache2
                ),
                Project(
                    "flexbox-layout",
                    "https://github.com/google/flexbox-layout",
                    License.Apache2
                ),
                Project(
                    "AndroidUtils",
                    "https://github.com/sungbin5304/AndroidUtils",
                    License.MIT
                ),
                Project(
                    "CrashReporter",
                    "https://github.com/MindorksOpenSource/CrashReporter",
                    License.Apache2
                ),
                Project(
                    "glide",
                    "https://github.com/bumptech/glide/google/flexbox-layout",
                    License.BSD
                ),
                Project(
                    "constraintlayout",
                    "https://github.com/androidx/constraintlayout",
                    License.Apache2
                )
            )
        )
    }
}
