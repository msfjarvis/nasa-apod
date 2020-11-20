package dev.msfjarvis.apod.data.local.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class SavedItemsDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  abstract fun saveImage(image: ImageEntity)

  @Delete
  abstract fun removeSavedImage(image: ImageEntity)

  @Query("SELECT EXISTS(SELECT 1 FROM saved_images WHERE date = :date)")
  abstract fun isImageSaved(date: String): Boolean

  @Query("SELECT * FROM saved_images")
  abstract fun getAllImages(): List<ImageEntity>
}
