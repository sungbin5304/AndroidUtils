package com.sungbin.sungbintool

import android.view.ViewGroup
import android.widget.FrameLayout

@Deprecated(
    message = "`Utils` is deprecated.\nPlease use `Util` instead of `Utils`.",
    replaceWith = ReplaceWith("MarginUtil")
)
object LayoutUtils {
    fun putMargin(layout: ViewGroup): FrameLayout {
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