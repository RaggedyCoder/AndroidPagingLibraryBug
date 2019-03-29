package android.paging.library.bug.ui

import android.os.Bundle
import android.paging.library.bug.R
import android.paging.library.bug.viewmodel.NewsViewModel
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_pagination.*

class PaginationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagination)

        val newsViewModel = ViewModelProviders.of(this)[NewsViewModel::class.java]
        val newsAdapter = NewsAdapter()
        newsRecyclerView.adapter = newsAdapter

        newsViewModel.newsCountData.observe(this, Observer {
            it?.let { count ->
                if (count == 0) {
                    newsViewModel.insertNews()
                }
            }
        })

        newsViewModel.newsLiveData.observe(this, Observer {
            newsAdapter.submitList(it)
        })
    }
}