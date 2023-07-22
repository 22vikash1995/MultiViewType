package com.example.multiviewtype

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class NewsDataAdapter():Adapter<CustomDataViewHolder>() {
    private val dataList= mutableListOf<DataModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomDataViewHolder {
        val layout=when(viewType){
            SHORT_NEWS->R.layout.short_news
            LONG_NEWS->R.layout.long_news
            HEADER_ONLY->R.layout.short_news
            else ->throw IllegalArgumentException("Invalid Type")
        }
    val view =LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return CustomDataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomDataViewHolder, position: Int) {
        holder.bindData(dataList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when(dataList[position]){
            is DataModel.ShortNews-> SHORT_NEWS
            is DataModel.LongNews-> LONG_NEWS
            else-> HEADER_ONLY
        }
    }

    fun setData(data:List<DataModel>){
        dataList.apply {
            clear()
            addAll(data)
        }
    }

    companion object{
        private const val SHORT_NEWS=1
        private const val LONG_NEWS=2
        private const val HEADER_ONLY=3
    }
}