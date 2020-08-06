package com.sungbin.sungbintool

import android.view.ViewGroup
import android.widget.FrameLayout

object LayoutUtils {
    fun putMargin(layout: ViewGroup): FrameLayout{
        val container = FrameLayout(layout.context)
        val params = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

        R.dimen.margin_default.apply {
            params.marginEnd
            params.marginStart
            params.topMargin
            params.bottomMargin
        }

        layout.layoutParams = params
        container.addView(layout)

        return container
    }
}