package com.example.multiviewtype

import java.util.Arrays

fun main(){
    smallestNum()
    bubbleSort()
}

fun smallestNum() {
    val array= arrayOf(21,71,31,41,1,11,25,10)
    var temp=array[0]
    var index=-1
    for (i in 1..array.size-1){
        if (temp>array[i]) {
            temp = array[i]
            index=i
        }
        else continue
    }
    println("Smallest number is:$temp \n and is found at:$index")
}

fun bubbleSort(){
    val array= arrayOf(21,71,31,41,81,11,25,10)
    var temp=0
    for (i in 0..array.size){
        for (j in 0..array.size-2){
            if (array[j]>array[j+1]){
                temp=array[j]
                array[j]=array[j+1]
                array[j+1]=temp
            }
        }
    }
    for (i in 0..array.size-1){
        println(array[i])
    }
}