package io.github.gouvinb.seagulls.feature.search.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel() : ViewModel() {
    val feedUiState: StateFlow<SearchUiState> = MutableStateFlow<SearchUiState>(SearchUiState.Success)
}

sealed interface SearchUiState {
    data object Loading : SearchUiState
    data object Success : SearchUiState
}
