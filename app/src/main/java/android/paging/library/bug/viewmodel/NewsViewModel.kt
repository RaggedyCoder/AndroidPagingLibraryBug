package android.paging.library.bug.viewmodel

import android.app.Application
import android.paging.library.bug.R
import android.paging.library.bug.dao.NewsDao
import android.paging.library.bug.model.News
import android.paging.library.bug.model.NewsResponse
import android.paging.library.bug.util.NewsDatabase
import android.paging.library.bug.util.parseAs
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import androidx.room.Room
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream


class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val newsDao: NewsDao
    val newsLiveData: LiveData<PagedList<News>>
    val newsCountData: LiveData<Int>

    init {
        val database = Room.databaseBuilder(application, NewsDatabase::class.java, "news_database")
            .allowMainThreadQueries()
            .build()
        newsDao = database.getNewsDao()
        newsLiveData = newsDao.select().toLiveData(10)
        newsCountData = newsDao.count()
    }

    fun insertNews() {
        val newsJson = readTextFile(getApplication<Application>().resources.openRawResource(R.raw.news))
        newsDao.insert(*newsJson.parseAs<NewsResponse>().newsList.toTypedArray())
    }

    fun readTextFile(inputStream: InputStream): String {
        val outputStream = ByteArrayOutputStream()

        val buf = ByteArray(1024)
        var len: Int
        try {
            len = inputStream.read(buf)
            while (len != -1) {
                outputStream.write(buf, 0, len)
                len = inputStream.read(buf)
            }
            outputStream.close()
            inputStream.close()
        } catch (e: IOException) {

        }

        return outputStream.toString()
    }
}