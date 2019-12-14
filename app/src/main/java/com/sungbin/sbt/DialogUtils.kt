package com.sungbin.sbt

import android.content.Context
import android.content.res.Resources
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout

object DialogUtils {
    fun makeMarginLayout(res: Resources, ctx: Context, layout: LinearLayout): FrameLayout{
        val container = FrameLayout(ctx)
        val params = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

        params.leftMargin = 16
        params.rightMargin = 16
        params.topMargin = 16

        layout.layoutParams = params
        container.addView(layout)

        return container
    }
}