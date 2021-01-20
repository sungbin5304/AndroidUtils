package me.sungbin.androidutils.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Created by SungBin on 2021-01-20.
 */

lateinit var imm: InputMethodManager

private fun getImm(context: Context): InputMethodManager {
    if (!::imm.isInitialized) {
        imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }
    return imm
}

fun EditText.isBlank() = this.text.toString().isBlank()

fun EditText.isEmpty() = this.text.toString().isEmpty()

fun EditText.isNotBlank() = this.text.toString().isNotBlank()

fun EditText.isNotEmpty() = this.text.toString().isNotEmpty()

fun EditText.showKeyboard() {
    getImm(this.context).showSoftInput(this, 0)
}

fun EditText.hideKeyboard() {
    getImm(this.context).hideSoftInputFromWindow(this.windowToken, 0)
}

@SuppressLint("ClickableViewAccessibility")
fun EditText.setEndDrawableClickEvent(action: (View) -> Unit) {
    this.setOnTouchListener(
        View.OnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= this.right - this.compoundDrawables[2].bounds.width()
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
