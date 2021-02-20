/*
 * Create by Ji Sungbin on 2021. 1. 30.
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * AndroidUtils license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/AndroidUtils/blob/master/LICENSE
 */

package me.sungbin.androidutils.util.licensediaog

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import me.sungbin.androidutils.extensions.get
import me.sungbin.sungbintool.R
import java.util.Locale
import java.util.SortedMap

internal class LicenseAdapter(
    private val projects: HashMap<License, MutableList<Item>>
) : RecyclerView.Adapter<LicenseAdapter.ViewHolder>() {
    inner class ViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bindViewHolder(_projects: HashMap<License, MutableList<Item>>) {
            val context = view.context
            fun openTab(address: String) {
                fun String.parseUri() =
                    if (contains("http")) toUri() else "http://$this".toUri()

                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        address.parseUri()
                    )
                )
            }

            fun sortProjectHashMap(projects: HashMap<License, MutableList<Item>>): SortedMap<License, MutableList<Item>> {
                val sortedProjects = hashMapOf<License, MutableList<Item>>()
                for (key in projects.keys) {
                    val sortedItemArray = projects[key]!!
                    sortedItemArray.sortWith(
                        Comparator { item, item2 ->
                            return@Comparator item.name.toLowerCase(Locale.getDefault())
                                .compareTo(item2.name.toLowerCase(Locale.getDefault()))
                        }
                    )
                    sortedProjects[key] = sortedItemArray
                }
                return sortedProjects.toSortedMap(
                    Comparator { item, item2 ->
                        return@Comparator item.name.toLowerCase(Locale.getDefault())
                            .compareTo(item2.name.toLowerCase(Locale.getDefault()))
                    }
                )
            }

            val projects = sortProjectHashMap(_projects)

            view[R.id.ll_container_license, LinearLayout::class.java].run {
                projects.forEach { project ->
                    val licenseViewBinding = LayoutInflater.from(context)
                        .inflate(R.layout.layout_license, ScrollView(context))
                    licenseViewBinding[R.id.tv_license_name, TextView::class.java].text =
                        project.key.name
                    licenseViewBinding[R.id.ll_container_project, LinearLayout::class.java].run {
                        project.value.forEach { item ->
                            addView(
                                TextView(context).apply {
                                    text = "  - ${item.name}"
                                    textSize = 20.toFloat()
                                    setTextColor(
                                        ContextCompat.getColor(
                                            context,
                                            R.color.colorBlack
                                        )
                                    )
                                    setOnClickListener {
                                        openTab(item.link)
                                    }
                                }
                            )
                        }
                    }
                    addView(licenseViewBinding[R.id.sv_container_main, ScrollView::class.java])
                }
            }
        }
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): LicenseAdapter.ViewHolder {
        val layout = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_license_container, viewGroup)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(@NonNull viewholder: ViewHolder, position: Int) {
        viewholder.bindViewHolder(projects)
    }

    override fun getItemCount() = 1
    override fun getItemId(position: Int) = position.toLong()
    override fun getItemViewType(position: Int) = position
}
