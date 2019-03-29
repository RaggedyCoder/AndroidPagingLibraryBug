package android.paging.library.bug.ui

import android.paging.library.bug.model.News
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

class NewsAdapter : PagedListAdapter<News, NewsViewHolder>(NEWS_DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsViewHolder.create(parent)

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position) ?: return
        holder.bindView(news)
    }

    companion object {
        private val NEWS_DIFF_CALLBACK = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News) = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: News, newItem: News) = oldItem == newItem
        }
    }
}