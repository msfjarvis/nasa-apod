package dev.msfjarvis.apod.data.local.persistence

import androidx.room.Embedded
import androidx.room.Entity
import dev.msfjarvis.apod.data.model.PictureDetail

@Entity(
  tableName = "saved_images",
  primaryKeys = ["date"],
)
data class ImageEntity(
  @Embedded
  val image: PictureDetail
)
