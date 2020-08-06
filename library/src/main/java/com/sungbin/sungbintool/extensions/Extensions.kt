package com.sungbin.sungbintool.extensions

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.IdRes
import com.sungbin.sungbintool.StringUtils

/**
 * Created by SungBin on 2020-06-10.
 */

fun View.hide(isGone: Boolean = false){
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
fun EditText.setEndDrawableClickEvent(action: (View) -> Unit){
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