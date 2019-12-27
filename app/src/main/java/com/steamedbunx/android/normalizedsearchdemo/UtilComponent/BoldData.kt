package com.steamedbunx.android.normalizedsearchdemo.UtilComponent

class BoldData(){

    val boldIndexs = mutableListOf<BoldDataPair>()

    fun add(index: Int){
        if(boldIndexs.isEmpty() || boldIndexs.last().end != index - 1){
            boldIndexs.add(BoldDataPair(index, index))
        }else{
            boldIndexs.last().end = index
        }
    }

    data class BoldDataPair(var start: Int, var end: Int)
}