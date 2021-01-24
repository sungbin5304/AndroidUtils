package me.sungbin.androidutils.util.licensediaog

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale
import java.util.SortedMap
import me.sungbin.sungbintool.R
import me.sungbin.sungbintool.databinding.LayoutLicenseBinding
import me.sungbin.sungbintool.databinding.LayoutLicenseContainerBinding

/**
 * Created by SungBin on 2021-01-20.
 */

internal class LicenseAdapter(
    private val projects: HashMap<License, MutableList<Item>>
) : RecyclerView.Adapter<LicenseAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: LayoutLicenseContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bindViewHolder(_projects: HashMap<License, MutableList<Item>>) {
            val context = binding.root.context
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

            binding.llContainerLicense.run {
                projects.forEach { project ->
                    val licenseViewBinding =
                        LayoutLicenseBinding.inflate(LayoutInflater.from(context))
                    licenseViewBinding.tvLicenseName.apply {
                        text = project.key.name
                    }
                    licenseViewBinding.llContainerProject.run {
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
                    addView(licenseViewBinding.svContainerMain)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutLicenseContainerBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )

    override fun onBindViewHolder(@NonNull viewholder: ViewHolder, position: Int) {
        viewholder.bindViewHolder(projects)
    }

    override fun getItemCount() = 1
    override fun getItemId(position: Int) = position.toLong()
    override fun getItemViewType(position: Int) = position
}
