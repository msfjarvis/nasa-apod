package dev.msfjarvis.apod.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dev.msfjarvis.apod.R
import dev.msfjarvis.apod.data.model.PictureDetail
import dev.msfjarvis.apod.databinding.ApodItemBinding

class ApodImagesAdapter(
  private val items: ArrayList<PictureDetail>,
  private val onClick: (Int) -> Unit,
  private val onFavoriteClick: (PictureDetail) -> Boolean,
) : RecyclerView.Adapter<ApodImagesAdapter.ViewHolder>() {
  private val originalItems = items

  fun filterImages(filter: (PictureDetail) -> Boolean) {
    val newItems = originalItems.filter(filter)
    items.clear()
    items.addAll(newItems)
    notifyDataSetChanged()
  }

  fun clearFilter() {
    items.clear()
    items.addAll(originalItems)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = ApodItemBinding.inflate(LayoutInflater.from(parent.context))
    return ViewHolder(binding, onClick, onFavoriteClick)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(position, items[position])
  }

  class ViewHolder(
    private val binding: ApodItemBinding,
    private val onClick: (Int) -> Unit,
    private val onFavoriteClick: (PictureDetail) -> Boolean,
  ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, pictureDetail: PictureDetail) {
      binding.thumbnail.load(pictureDetail.url) {
        placeholder(R.drawable.placeholder)
        crossfade(true)
      }
      binding.thumbnail.setOnClickListener {
        onClick(position)
      }
      with(binding.favoriteButton) {
        setOnClickListener {
          if (onFavoriteClick(pictureDetail)) {
            setImageResource(R.drawable.favorite_filled_24px)
          } else {
            setImageResource(R.drawable.favorite_border_24px)
          }
        }
      }
    }
  }

  override fun getItemCount(): Int {
    return items.size
  }
}
