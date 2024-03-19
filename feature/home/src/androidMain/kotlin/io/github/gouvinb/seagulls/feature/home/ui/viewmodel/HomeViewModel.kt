package io.github.gouvinb.seagulls.feature.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel() : ViewModel() {
    val feedUiState: StateFlow<HomeUiState> = MutableStateFlow<HomeUiState>(HomeUiState.Success)
}

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data object Success : HomeUiState
}
