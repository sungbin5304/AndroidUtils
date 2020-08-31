package com.sungbin.sungbintool.extensions

import android.annotation.SuppressLint
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.res.ColorStateList
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.core.widget.ImageViewCompat
import com.sungbin.sungbintool.StringUtils


/**
 * Created by SungBin on 2020-06-10.
 */

fun ImageView.setTint(color: Int) = ImageViewCompat.setImageTintList(
    this,
    ColorStateList.valueOf(
        color
    )
)

fun String.replaceLast(a: String, b: String): String {
    return if (this.contains(a)) {
        val lastIndex = this.lastIndexOf(a)
        val string1 = this.substring(0, lastIndex)
        val string2 = this.substring((lastIndex + a.length), this.length)
        string1 + b + string2
    } else this
}

fun String.toChar() = this[0]

fun String.isUpperCase() = Character.isUpperCase(this.toChar())

fun String.isLowerCase() = Character.isLowerCase(this.toChar())

fun EditText.showKeyboard() {
    val imm = this.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, 0)
}

fun EditText.hideKeyboard() {
    val imm = this.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.hide(isGone: Boolean = false) {
    this.visibility = if (isGone) View.GONE else View.INVISIBLE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

operator fun TextView.plusAssign(text: String) {
    this.text = text
}

fun TextView.clear() {
    this.text = ""
}

operator fun View.get(@IdRes id: Int) = this.findViewById<View>(id)!!

@SuppressLint("ClickableViewAccessibility")
fun EditText.setEndDrawableClickEvent(action: (View) -> Unit) {
    this.setOnTouchListener(View.OnTouchListener { view, event ->
        if (event.action == MotionEvent.ACTION_UP) {
            if (event.rawX >= this.right - this.compoundDrawables[2].bounds.width()
            ) {
                action(view)
                return@OnTouchListener true
            }
        }
        false
    })
}

fun String?.toEditable() = StringUtils.toEditable(this.toString())

interface TextWatcherListener : TextWatcher {
    override fun afterTextChanged(s: Editable?) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
}

fun EditText.beforeTextChange(action: (s: CharSequence?, start: Int, count: Int, after: Int) -> Unit) {
    addTextChangedListener(object : TextWatcherListener {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            action.invoke(s, start, count, after)
        }
    })
}

fun EditText.afterTextChanged(action: (s: Editable?) -> Unit) {
    addTextChangedListener(object : TextWatcherListener {
        override fun afterTextChanged(s: Editable?) {
            action.invoke(s)
        }
    })
}

fun EditText.onTextChanged(action: (s: CharSequence?, start: Int, before: Int, count: Int) -> Unit) {
    addTextChangedListener(object : TextWatcherListener {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            action.invoke(s, start, before, count)
        }
    })
}