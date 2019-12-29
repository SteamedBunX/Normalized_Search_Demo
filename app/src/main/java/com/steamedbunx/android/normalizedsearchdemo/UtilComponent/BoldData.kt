package com.steamedbunx.android.normalizedsearchdemo.UtilComponent

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan

class BoldData(){

    val boldIndexs = mutableListOf<BoldDataPair>()

    fun add(index: Int){
        if(boldIndexs.isEmpty() || boldIndexs.last().end != index - 1){
            boldIndexs.add(BoldDataPair(index, index))
        }else{
            boldIndexs.last().end = index
        }
    }

    fun processBoldText(source: String):SpannableStringBuilder{
        val result = SpannableStringBuilder(source)
        boldIndexs.forEach{
            result.setSpan(
                StyleSpan(Typeface.BOLD),
                it.start, it.end+1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        return result
    }

    data class BoldDataPair(var start: Int, var end: Int)
}