package dev.msfjarvis.apod.data.local.persistence

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
  entities = [
    ImageEntity::class,
  ],
  exportSchema = true,
  version = 1,
)
abstract class SavedPostsDatabase : RoomDatabase() {
  abstract fun imagesDao(): SavedItemsDao
}
