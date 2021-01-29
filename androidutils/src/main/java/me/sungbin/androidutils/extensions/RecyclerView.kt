/*
 * Create by Sungbin Ji on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/sungbin5304/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.extensions

import android.os.Build
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

fun RecyclerView.toBottomScroll() {
    scrollToPosition(this.adapter?.itemCount?.minus(1) ?: return)
}

fun RecyclerView.setFab(fab: View) {
    if (fab is FloatingActionButton || fab is ExtendedFloatingActionButton) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setOnScrollChangeListener { _, _, y, _, oldY ->
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
