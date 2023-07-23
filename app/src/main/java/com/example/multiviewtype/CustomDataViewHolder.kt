package com.example.multiviewtype

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private fun bindShortNews(item: DataModel.ShortNews) {
        itemView.findViewById<TextView>(R.id.tv_desc).text = item.header
        itemView.findViewById<ImageView>(R.id.sht_image).setBackgroundResource(item.image)
    }

    private fun bindLongNews(item: DataModel.LongNews) {
        itemView.findViewById<TextView>(R.id.tv_lng_heading).text = item.header
        itemView.findViewById<ImageView>(R.id.iv_lng).setBackgroundResource(item.image)
        itemView.findViewById<TextView>(R.id.tv_lng_desc).text = item.desc
    }

    fun bindData(data: DataModel) {
        when (data) {
            is DataModel.ShortNews -> bindShortNews(data)

            is DataModel.LongNews -> bindLongNews(data)
        }
    }
}