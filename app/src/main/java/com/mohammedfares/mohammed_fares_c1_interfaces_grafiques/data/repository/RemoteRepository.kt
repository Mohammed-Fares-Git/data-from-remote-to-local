package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.data.repository

import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.data.remote.api.PcApiService
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model.Ordinateur
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    val api: PcApiService
)  {
    suspend fun getAll(): List<Ordinateur> {
        return api.getAll()
    }
}