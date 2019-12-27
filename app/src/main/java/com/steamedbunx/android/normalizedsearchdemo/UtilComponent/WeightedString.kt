package com.steamedbunx.android.normalizedsearchdemo.UtilComponent

import android.text.SpannableString

data class WeightedString(
    val content:SpannableString,
    val weight:Int
)