package me.sungbin.androidutils.util.licensediaog

import android.app.Activity
import android.app.AlertDialog
import android.widget.ScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by SungBin on 2021-01-20.
 */

internal class LicenseDialog(val activity: Activity) {
    fun create(title: String, projects: List<Project>) {
        fun Project.toItem() = Item(name, link)

        val values = HashMap<License, MutableList<Item>>()
        projects.forEach { project ->
            values[project.license]?.let {
                values[project.license] = it.plus(project.toItem()).toMutableList()
            } ?: run {
                values[project.license] = mutableListOf(project.toItem())
            }
        }
        val licenseRecyclerView = RecyclerView(activity).apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            adapter = LicenseAdapter(values)
        }
        val scrollview = ScrollView(activity).apply {
            addView(licenseRecyclerView)
        }
        val dialog = AlertDialog.Builder(activity)
        dialog.setTitle(title)
        dialog.setView(scrollview)
        dialog.show()
    }
}