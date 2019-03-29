package android.paging.library.bug.ui

import android.paging.library.bug.R
import android.paging.library.bug.model.News
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_news.view.*
import java.text.SimpleDateFormat
import java.util.*

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val outputFormatter = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())

    companion object {
        fun create(viewGroup: ViewGroup) =
            NewsViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item_news, viewGroup, false))
    }

    fun bindView(news: News) {
        Glide.with(itemView).load(news.imageUrl).into(itemView.newsImageView)
        Glide.with(itemView).load(news.avatar).into(itemView.newsCreatorImageView)
        itemView.nameTextView.text = news.title
        itemView.bodyTextView.text = news.body
        itemView.timeTextView.text = outputFormatter.format(news.createdAt)
    }
}