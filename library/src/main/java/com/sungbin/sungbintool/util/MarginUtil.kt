package com.sungbin.sungbintool.util

import android.view.ViewGroup
import android.widget.FrameLayout
import com.sungbin.sungbintool.R


object MarginUtil {
    fun put(layout: ViewGroup): FrameLayout {
        val container = FrameLayout(layout.context)
        val params = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

        R.dimen.margin_default.let {
            params.marginEnd = it
            params.marginStart = it
            params.topMargin = it
            params.bottomMargin = it
        }

        layout.layoutParams = params
        container.addView(layout)

        return container
    }
}