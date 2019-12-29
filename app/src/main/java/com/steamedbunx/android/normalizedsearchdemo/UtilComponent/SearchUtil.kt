package com.steamedbunx.android.normalizedsearchdemo.UtilComponent

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan

fun getNormalMatchWeightedString(matchPhrase: CharSequence, inputString: String): WeightedString? {
    // process the text for searching, ignoring spaces completely
    //val searchPhrase = matchPhrase.trim().replace("\\s".toRegex(), "").toLowerCase()
    val searchPhrase = matchPhrase
    val boldData = BoldData()
    var currentIndexForNormalMatch = 0

    // i need keep track of the index, so when a matched char is find
    // I can bold that character
    // this iterate through the entire string once
    for (i in inputString.indices) {
        // we find a match
        if (inputString[i] == searchPhrase[currentIndexForNormalMatch]) {
            // bold the character
            boldData.add(i)
            // let index move up
            currentIndexForNormalMatch++
            // we find everything, in order
            if (currentIndexForNormalMatch >= searchPhrase.length) {
                // this is a normal result with no pattern
                val result = WeightedString(boldData.processBoldText(inputString), 0)
                return result
            }
        }
    }
    // result not find after the entire iteration, pattern does not match
    return null
}

fun searchListForResults(searchPhrase: String, inputs: List<String>): List<WeightedString> {
    val result = ArrayList<WeightedString>()
    val normalizedSearchPhrase = searchPhrase.trim().replace("[^a-zA-Z]".toRegex(), "").toLowerCase()
    if (!normalizedSearchPhrase.isBlank()) {
        inputs.forEach {
            val potentialResult =
                getNormalMatchWeightedString(
                    normalizedSearchPhrase,
                    it
                )
            if (potentialResult != null) {
                result.add(potentialResult)
            }
        }
    }
    return result.toList()
}