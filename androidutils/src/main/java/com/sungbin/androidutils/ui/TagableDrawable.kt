package com.sungbin.androidutils.ui


import android.graphics.*
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.TextPaint


internal class TagableDrawable(
    text: String,
    tagBackgroundColor: Int, tagTextSize: Int,
    tagTextPadding: Int, tagTextStyle: Int,
    tagRadius: Int
) : Drawable() {

    private val bitmap: Bitmap
    private val width: Int
    private val height: Int
    private val paint: Paint

    init {
        val textBounds = Rect()
        val textPaint =
            TextPaint(Paint.ANTI_ALIAS_FLAG or Paint.SUBPIXEL_TEXT_FLAG)
        textPaint.typeface = Typeface.create(
            "sans-serif-black",
            tagTextStyle
        )
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.textSize = tagTextSize.toFloat()
        textPaint.getTextBounds(text, 0, text.length, textBounds)
        this.height = tagTextPadding + textBounds.height() + tagTextPadding
        this.width = tagTextPadding + textBounds.width() + tagTextPadding
        val bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888)
        bitmap.setHasAlpha(true)
        val canvas = Canvas(bitmap)
        val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        backgroundPaint.color = tagBackgroundColor
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(
                0f, 0f, this.width.toFloat(), this.height.toFloat(),
                tagRadius.toFloat(), tagRadius.toFloat(),
                backgroundPaint
            )
        } else {
            canvas.drawRect(0f, 0f, this.width.toFloat(), this.height.toFloat(), backgroundPaint)
        }
        textPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        val xPos = (canvas.width / 2).toFloat()
        val yPos = (canvas.height / 2 - (textPaint.descent() + textPaint.ascent()) / 2)
        canvas.drawText(text, xPos, yPos, textPaint)
        this.bitmap = bitmap
        paint = Paint()
    }

    override fun getIntrinsicWidth() = this.width

    override fun getIntrinsicHeight() = this.height

    override fun getOpacity() = PixelFormat.UNKNOWN

    override fun setAlpha(alpha: Int) = Unit

    override fun draw(canvas: Canvas) {
        canvas.drawBitmap(
            this.bitmap,
            bounds.left.toFloat(),
            bounds.top.toFloat(),
            paint
        )
    }

    override fun setColorFilter(cf: ColorFilter?) {
        paint.colorFilter = cf
    }
}