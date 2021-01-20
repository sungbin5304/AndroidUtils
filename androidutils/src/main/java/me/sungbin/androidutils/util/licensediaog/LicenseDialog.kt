package me.sungbin.androidutils.util.licensediaog

import android.app.Activity
import android.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by SungBin on 2021-01-20.
 */

internal class LicenseDialog(val activity: Activity) {
    fun create(title: String, projects: Array<Project>) {
        fun Project.toItem() = Item(name, link)

        val values = HashMap<License, Array<Item>>()
        projects.map { project ->
            values[project.license]?.let {
                values[project.license] = it.plus(project.toItem())
            } ?: run {
                values[project.license] = arrayOf(project.toItem())
            }
        }
        val licenseRecyclerView = RecyclerView(activity).apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }
        val dialog = AlertDialog.Builder(activity)
        dialog.setTitle(title)
        dialog.setView(licenseRecyclerView)
        dialog.show()
    }
}
