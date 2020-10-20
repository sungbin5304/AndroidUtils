package com.sungbin.sungbintool.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.regex.Pattern


/**
 * Created by SungBin on 2020-06-10.
 */

lateinit var imm: InputMethodManager

private fun getImm(context: Context): InputMethodManager {
    if (!::imm.isInitialized) {
        imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }
    return imm
}

fun ImageView.setTint(color: Int) = ImageViewCompat.setImageTintList(
    this, color.toColorStateList()
)

fun RecyclerView.toBottomScroll() {
    this.scrollToPosition(this.adapter?.itemCount?.minus(1) ?: return)
}

fun Int.toColorStateList() = ColorStateList.valueOf(this)

fun String.replaceLast(findText: String, replaceText: String): String {
    return if (this.contains(findText)) {
        val lastIndex = this.lastIndexOf(findText)
        val string1 = this.substring(0, lastIndex)
        val string2 = this.substring((lastIndex + findText.length), this.length)
        string1 + replaceText + string2
    } else this
}

fun String.isUpperCase() = Pattern.matches("[A-Z]*$", this)

fun String.isLowerCase() = Pattern.matches("[a-z]*$", this)

fun EditText.showKeyboard() {
    getImm(this.context).showSoftInput(this, 0)
}

fun EditText.hideKeyboard() {
    getImm(this.context).hideSoftInputFromWindow(this.windowToken, 0)
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

fun String?.toEditable() = SpannableStringBuilder(this.toString())

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

fun RecyclerView.setFab(fab: View) {
    if (fab is FloatingActionButton || fab is ExtendedFloatingActionButton) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.setOnScrollChangeListener { _, _, y, _, oldY ->
                if (y < oldY) { // Up
                    if (fab is FloatingActionButton) {
                        fab.show()
                    } else {
                        (fab as ExtendedFloatingActionButton).extend()
                    }
                }

                if (y > oldY) { // Down
                    if (fab is FloatingActionButton) {
                        fab.hide()
                    } else {
                        (fab as ExtendedFloatingActionButton).shrink()
                    }
                }
            }
        }
    }
}