package android.paging.library.bug.dao

import android.paging.library.bug.model.News
import android.paging.library.bug.util.DBConstants
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query


@Dao
interface NewsDao : IDao<News> {

    @Query("SELECT * FROM ${DBConstants.NEWS_TABLE}")
    fun select(): DataSource.Factory<Int, News>

    @Query("SELECT COUNT(${DBConstants.ID_COLUMN}) FROM ${DBConstants.NEWS_TABLE}")
    fun count(): LiveData<Int>
}