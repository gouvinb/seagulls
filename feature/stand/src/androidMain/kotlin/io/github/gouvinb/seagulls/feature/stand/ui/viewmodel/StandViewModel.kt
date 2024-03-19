/*
 * Copyright 2024 Gouvinb
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
