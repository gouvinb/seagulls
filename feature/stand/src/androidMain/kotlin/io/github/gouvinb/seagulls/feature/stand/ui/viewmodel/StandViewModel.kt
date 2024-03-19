package io.github.gouvinb.seagulls.feature.stand.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.gouvinb.seagulls.lib.core.domain.usecase.RssUseCase
import io.github.gouvinb.seagulls.lib.core.ui.mapper.RssUiMapper
import io.github.gouvinb.seagulls.lib.core.ui.model.RssUi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class StandViewModel(
    private val useCase: RssUseCase,
) : ViewModel() {
    val standUiState: StateFlow<StandUiState> =
        useCase.getFeedList()
            .map {
                StandUiState.Success(
                    list = it.map { feedItemDomain -> RssUiMapper.mapFromDomain(feedItemDomain) },
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = StandUiState.Loading,
            )

}

sealed interface StandUiState {
    data object Loading : StandUiState
    data class Success(val list: List<RssUi>) : StandUiState
}
