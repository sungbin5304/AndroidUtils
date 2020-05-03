package com.sungbin.sungbintool

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout

object LayoutUtils {
    fun putMargin(ctx: Context, layout: ViewGroup): FrameLayout{
        val container = FrameLayout(ctx)
        val params = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

        params.leftMargin = R.dimen.normal_margin
        params.rightMargin = R.dimen.normal_margin
        params.topMargin = R.dimen.normal_margin
        params.bottomMargin = R.dimen.normal_margin

        layout.layoutParams = params
        container.addView(layout)

        return container
    }
}