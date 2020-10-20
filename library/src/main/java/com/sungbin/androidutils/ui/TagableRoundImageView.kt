package com.sungbin.androidutils.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import androidx.appcompat.widget.AppCompatImageView
import com.sungbin.sungbintool.R


class TagableRoundImageView : AppCompatImageView {
    private var tagBoundsSet = false
    private var tag: TagableDrawable? = null

    private var tagText: String? = null
    private var tagTextGravity: Int = Gravity.END or Gravity.BOTTOM
    private var tagTextPadding: Int = dp2px(8)
    private var tagTextSize: Int = dp2px(15)
    private var tagTextStyle: Int = Typeface.NORMAL
    private var tagBackgroundColor: Int = Color.WHITE
    private var tagRadius: Int = dp2px(2)
    private var imageRadius = dp2px(16)

    private var bitmapRect: RectF? = null
    private var clipPath: Path? = null

    /**
     * Create a new TagableRoundImageView.
     * @param context current activity
     */
    constructor(context: Context) : super(context) {
        TagableRoundImageView(context, null)
    }

    /**
     * Constructor for inflation from XML layout
     * @param context current activity
     * @param attrs provided by layout
     */
    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        clipPath = Path()
        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.TagableRoundImageView,
            0,
            0
        )
        tagTextGravity = a.getInt(
            R.styleable.TagableRoundImageView_triv_tagGravity,
            this.tagTextGravity
        )
        tagTextStyle = a.getInt(
            R.styleable.TagableRoundImageView_triv_tagTextStyle,
            this.tagTextStyle
        )
        tagBackgroundColor = a.getColor(
            R.styleable.TagableRoundImageView_triv_tagBackgroundColor,
            this.tagBackgroundColor
        )
        tagTextSize = a.getDimensionPixelSize(
            R.styleable.TagableRoundImageView_triv_tagTextSize,
            this.tagTextSize
        )
        tagTextPadding = a.getDimensionPixelSize(
            R.styleable.TagableRoundImageView_triv_tagPadding,
            this.tagTextPadding
        )
        imageRadius = a.getDimensionPixelSize(
            R.styleable.TagableRoundImageView_triv_imageRadius,
            this.imageRadius
        )
        tagTextPadding = a.getDimensionPixelSize(
            R.styleable.TagableRoundImageView_triv_tagPadding,
            this.tagTextPadding
        )
        tagText = a.getString(
            R.styleable.TagableRoundImageView_triv_tagText
        )
        a.recycle()
        tagText?.let { set(it) }
    }

    /**
     * Set the value of TagableRoundImageView
     * @param text text for tag (required)
     * @param tagBackgroundColor color for tag background (Default: Color.WHITE)
     * @param tagTextSize size for tag text (Default: 15dp)
     * @param tagTextPadding padding for tag layout (Default: 8dp)
     * @param tagTextStyle text style for tag text  (Default: Typeface.NORMAL)
     * @param tagRadius radius for tag (Default: 2dp)
     * @param imageRadius radius for image (Default: 16dp)
     */
    @Suppress("DEPRECATION")
    fun set(
        text: String, tagBackgroundColor: Int = this.tagBackgroundColor,
        tagTextSize: Int = this.tagTextSize, tagTextPadding: Int = this.tagTextPadding,
        tagTextStyle: Int = this.tagTextStyle, tagRadius: Int = this.tagRadius,
        imageRadius: Int = this.imageRadius
    ) {
        tag = TagableDrawable(
            text, tagBackgroundColor, tagTextSize,
            tagTextPadding, tagTextStyle, tagRadius
        )
        tag!!.setColorFilter(tagBackgroundColor, PorterDuff.Mode.SRC_IN)
        this.imageRadius = imageRadius
        tagBoundsSet = false
        invalidate()
    }

    override fun draw(canvas: Canvas) {
        try {
            clipPath = Path()
            clipPath!!.reset()
            if (bitmapRect == null) {
                bitmapRect = RectF(
                    0f, 0f,
                    width.toFloat(),
                    height.toFloat()
                )
            }
            clipPath!!.addRoundRect(
                bitmapRect!!,
                imageRadius.toFloat(),
                imageRadius.toFloat(),
                Path.Direction.CW
            )
            canvas.clipPath(clipPath!!)
            super.draw(canvas)
            if (tag != null) {
                tag!!.draw(canvas)
                if (!tagBoundsSet) {
                    layoutTag()
                }
                tag!!.draw(canvas)
            }
        } catch (e: Exception) {
            Log.e("TagableRoundImageView", "Error at image draw!\n$e")
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        bitmapRect = RectF(0f, 0f, w.toFloat(), h.toFloat())
        if (tag != null) {
            layoutTag()
        }
    }

    private fun layoutTag() {
        val tagBounds = tag!!.bounds
        Gravity.apply(
            tagTextGravity,
            tag!!.intrinsicWidth,
            tag!!.intrinsicHeight,
            Rect(0, 0, width, height),
            tagTextPadding, tagTextPadding,
            tagBounds
        )
        tag!!.bounds = tagBounds
        tagBoundsSet = true
    }

    private fun dp2px(dp: Int) = (dp * context.resources.displayMetrics.density + 0.5f).toInt()
}