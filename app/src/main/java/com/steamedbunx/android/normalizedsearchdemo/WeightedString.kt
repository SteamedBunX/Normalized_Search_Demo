package com.steamedbunx.android.normalizedsearchdemo

import android.text.SpannableString

data class WeightedString(
    val content:SpannableString,
    val weight:Int
)