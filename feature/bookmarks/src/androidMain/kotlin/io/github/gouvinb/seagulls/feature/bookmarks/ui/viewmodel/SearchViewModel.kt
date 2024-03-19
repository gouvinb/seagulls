package io.github.gouvinb.seagulls.feature.bookmarks.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BookmarksViewModel() : ViewModel() {
    val feedUiState: StateFlow<BookmarksUiState> = MutableStateFlow<BookmarksUiState>(BookmarksUiState.Success)
}

sealed interface BookmarksUiState {
    data object Loading : BookmarksUiState
    data object Success : BookmarksUiState
}
