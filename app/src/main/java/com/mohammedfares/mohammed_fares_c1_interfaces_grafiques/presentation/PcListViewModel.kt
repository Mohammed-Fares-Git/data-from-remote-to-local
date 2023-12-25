package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.comon.Resource
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model.OrdinateurLikebale
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.use_case.GetAllPcUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PcListViewModel @Inject constructor(
    val api: GetAllPcUseCase
): ViewModel() {

    private val _PcStateFlow = MutableStateFlow<Resource<List<OrdinateurLikebale>>>(Resource.Loading())
    val pcStateFlow: StateFlow<Resource<List<OrdinateurLikebale>>> = _PcStateFlow

    fun getAll() = viewModelScope.launch {
        api().collect {
            _PcStateFlow.value = it
        }
    }

    init {
        getAll()
    }
}