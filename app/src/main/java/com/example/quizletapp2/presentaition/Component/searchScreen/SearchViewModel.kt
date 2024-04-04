package com.example.quizletapp2.presentaition.Component.searchScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizletapp2.presentaition.Home.listCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(): ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _topicCards= MutableStateFlow(listCard)

    @OptIn(FlowPreview::class)
    val topicCards = searchText
        .debounce(100L)
        .onEach { _isSearching.update { true }}
        .combine(_topicCards){text, topicCards ->
            if(text.isBlank()){
                listOf()
            }
            else{
                delay(200L)
                topicCards.filter {
                    it.doesMatchSearchQuery(text)
                }
            }

        }
        .onEach {
            _isSearching.update { false }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _topicCards.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }



}