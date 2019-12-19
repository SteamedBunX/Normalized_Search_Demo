package com.steamedbunx.android.normalizedsearchdemo.ui.main

import android.text.SpannableStringBuilder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.steamedbunx.android.normalizedsearchdemo.getPhraseBank
import com.steamedbunx.android.normalizedsearchdemo.searchListForResults

class MainViewModel : ViewModel() {
    val listForSearch = getPhraseBank()
    val currentSearchPhrase = MutableLiveData<String>()

    private val _currentSearchResult = MutableLiveData<SpannableStringBuilder>()
    val currentSearchResult: LiveData<SpannableStringBuilder>
        get() = _currentSearchResult

    fun updateSearchResult(){
        val result = SpannableStringBuilder()
        result.append("Trying to search\n")
        result.append(currentSearchPhrase.value?.trim()?.replace("[^a-zA-Z]".toRegex(), "")?.toLowerCase() ?: "")
        result.append("\n")
        val resultList = searchListForResults(currentSearchPhrase.value ?: "", listForSearch)
        resultList.sortedWith(compareBy({it.weight}, {it.content.toString()}))
        resultList.forEach {
            result.append(it.content).append("\n").append(it.weight.toString()).append("\n")
        }
        _currentSearchResult.value = result
    }
}
