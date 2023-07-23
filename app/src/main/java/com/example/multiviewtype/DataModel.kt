package com.example.multiviewtype

sealed class DataModel {
    data class ShortNews(val image:Int,val header:String):DataModel()
    data class LongNews(val image:Int, val header:String?,val desc:String?, val rate:Int):DataModel()
}