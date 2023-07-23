package com.example.multiviewtype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.multiviewtype.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     lateinit var newsAdapter: NewsDataAdapter
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        initView()
    }

    private fun initView(){
        newsAdapter= NewsDataAdapter()
        newsAdapter.setData(getNewsData())
        binding.rvNews.apply {
            layoutManager=LinearLayoutManager(this@MainActivity, VERTICAL,false)
            hasFixedSize()
            this.adapter=newsAdapter
        }
    }

    private fun getNewsData(): List<DataModel> = listOf(
        DataModel.ShortNews(R.drawable.news1,"Title1"),
        DataModel.LongNews(R.drawable.news2,"LongTitle1","LongDesc",4),
        DataModel.ShortNews(R.drawable.news1,"Title2"),
        DataModel.LongNews(R.drawable.images,"LongTitle2","LongDesc",4),
        DataModel.ShortNews(R.drawable.download,"Title3"),
        DataModel.LongNews(R.drawable.news1,"LongTitle3","LongDesc",4)
    )

}