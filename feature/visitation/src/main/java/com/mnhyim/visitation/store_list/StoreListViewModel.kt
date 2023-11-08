package com.mnhyim.visitation.store_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.domain.usecase.DataUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class StoreListViewModel @Inject constructor(
    private val dataUseCases: DataUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(StoreListState())
    val state = _state.asStateFlow()

    init {
        getAllStore()
    }

    private fun getAllStore() {
        viewModelScope.launch {
            val data = dataUseCases.getAllStoreUseCase().first()
            _state.update { it.copy(stores = data) }
            Timber.d("ResultSuccess: $data")
        }
    }
}