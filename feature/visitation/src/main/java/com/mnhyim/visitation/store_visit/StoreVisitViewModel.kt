package com.mnhyim.visitation.store_visit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.domain.usecase.DataUseCases
import com.mnhyim.visitation.navArgs
import com.mnhyim.visitation.store_detail.StoreDetailNavArgs
import com.mnhyim.visitation.store_list.StoreListState
import com.mnhyim.visitation.store_visit.components.StoreVisitNavArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class StoreVisitViewModel @Inject constructor(
    private val dataUseCases: DataUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(StoreVisitState())
    val state = _state.asStateFlow()

    private val navArgs: StoreVisitNavArgs = savedStateHandle.navArgs()

    init {
        getStoreById(navArgs.id)
    }

    private fun getStoreById(id: String) {
        viewModelScope.launch {
            val data = dataUseCases.getStoreById(id).first()
            _state.update { it.copy(stores = data) }
            Timber.d("ResultSuccess: $data")
        }
    }
}