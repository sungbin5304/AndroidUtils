package me.sungbin.androidutils.extensions

import android.os.Build
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Created by SungBin on 2021-01-20.
 */

fun RecyclerView.toBottomScroll() {
    this.scrollToPosition(this.adapter?.itemCount?.minus(1) ?: return)
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