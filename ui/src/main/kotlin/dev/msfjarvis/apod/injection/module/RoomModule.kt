package dev.msfjarvis.apod.injection.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.msfjarvis.apod.data.local.persistence.SavedPostsDatabase

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {
  @Provides
  fun provideRoomDB(@ApplicationContext context: Context): SavedPostsDatabase {
    return Room.databaseBuilder(context, SavedPostsDatabase::class.java, "saved_posts_db.db")
      .build()

  }
}
