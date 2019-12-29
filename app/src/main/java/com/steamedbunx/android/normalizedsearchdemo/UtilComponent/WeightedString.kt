package com.steamedbunx.android.normalizedsearchdemo.UtilComponent

import android.text.SpannableString
import android.text.SpannableStringBuilder

data class WeightedString(
    val content: SpannableStringBuilder,
    val weight:Int
)