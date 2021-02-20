/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

lateinit var imm: InputMethodManager

private fun getImm(context: Context): InputMethodManager {
    if (!::imm.isInitialized) {
        imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }
    return imm
}

fun EditText.isBlank() = text.toString().isBlank()

fun EditText.isEmpty() = text.toString().isEmpty()

fun EditText.isNotBlank() = text.toString().isNotBlank()

fun EditText.isNotEmpty() = text.toString().isNotEmpty()

fun EditText.showKeyboard() {
    getImm(context).showSoftInput(this, 0)
}

fun EditText.hideKeyboard() {
    getImm(context).hideSoftInputFromWindow(windowToken, 0)
}

@SuppressLint("ClickableViewAccessibility")
fun EditText.setEndDrawableClickEvent(action: (View) -> Unit) {
    setOnTouchListener(
        View.OnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= right - compoundDrawables[2].bounds.width()
                ) {
                    action(view)
                    return@OnTouchListener true
                }
            }
            false
        }
    )
}

interface TextWatcherListener : TextWatcher {
    override fun afterTextChanged(s: Editable?) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
}

fun EditText.beforeTextChange(action: (s: CharSequence?, start: Int, count: Int, after: Int) -> Unit) {
    addTextChangedListener(object : TextWatcherListener {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            action(s, start, count, after)
        }
    })
}

fun EditText.afterTextChanged(action: (s: Editable?) -> Unit) {
    addTextChangedListener(object : TextWatcherListener {
        override fun afterTextChanged(s: Editable?) {
            action(s)
        }
    })
}

fun EditText.onTextChanged(action: (s: CharSequence?, start: Int, before: Int, count: Int) -> Unit) {
    addTextChangedListener(object : TextWatcherListener {
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            action(s, start, before, count)
        }
    })
}
