package dev.msfjarvis.apod.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dev.msfjarvis.apod.R
import dev.msfjarvis.apod.data.model.PictureDetail
import dev.msfjarvis.apod.databinding.ApodItemBinding

class ApodImagesAdapter(
  private val items: List<PictureDetail>,
  private val onClick: (Int) -> Unit,
) : RecyclerView.Adapter<ApodImagesAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ApodItemBinding.inflate(LayoutInflater.from(parent.context))
    return ViewHolder(binding, onClick)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(position, items[position])
  }

  class ViewHolder(
    private val binding: ApodItemBinding,
    private val onClick: (Int) -> Unit,
  ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, pictureDetail: PictureDetail) {
      binding.thumbnail.load(pictureDetail.url) {
        placeholder(R.drawable.placeholder)
        crossfade(true)
      }
      binding.thumbnail.setOnClickListener {
        onClick(position)
      }
    }
  }

  override fun getItemCount(): Int {
    return items.size
  }
}
