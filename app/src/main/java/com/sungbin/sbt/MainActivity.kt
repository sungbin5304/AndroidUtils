package com.sungbin.sbt

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.sungbin.androidutils.annotation.Logging
import com.sungbin.androidutils.extensions.get
import com.sungbin.androidutils.extensions.hide
import com.sungbin.androidutils.ui.TagableRoundImageView

@Logging
class MainActivity : AppCompatActivity() {

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LayoutInflater.from(applicationContext)
            .inflate(R.layout.activity_main, null) as RelativeLayout
        layout[R.id.triv, TagableRoundImageView::class.java].hide()
    }
}
