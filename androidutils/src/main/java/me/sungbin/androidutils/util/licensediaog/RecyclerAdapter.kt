package me.sungbin.androidutils.util.licensediaog

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import me.sungbin.sungbintool.databinding.LayoutLicenseBinding
import me.sungbin.sungbintool.databinding.LayoutLicenseContainerBinding

/**
 * Created by SungBin on 2021-01-20.
 */

internal class RecyclerAdapter(
    private val projects: HashMap<License, Array<Item>>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: LayoutLicenseContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindViewHolder(projects: HashMap<License, Array<Item>>) {
            fun openTab(address: String) {
                binding.root.context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        address.toUri()
                    )
                )
            }

            binding.llContainerLicense.run {
                projects.map { project ->
                    val licenseViewBinding =
                        LayoutLicenseBinding.inflate(LayoutInflater.from(binding.root.context))
                    licenseViewBinding.tvLicenseName.apply {
                        text = project.key.name
                    }
                    licenseViewBinding.llContainerProject.run {
                        project.value.map { item ->
                            val textview = TextView(binding.root.context).apply {
                                text = item.name
                                setOnClickListener {
                                    openTab(item.link)
                                }
                            }
                            addView(textview)
                        }
                    }
                    addView(licenseViewBinding.root)
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
