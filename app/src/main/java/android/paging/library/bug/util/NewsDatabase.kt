package android.paging.library.bug.util

import android.paging.library.bug.dao.NewsDao
import android.paging.library.bug.model.News
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [News::class], version = 1)
@TypeConverters(value = [DateConverter::class])
abstract class NewsDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao
}