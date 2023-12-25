package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.data.remote.api

import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.comon.Constante
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model.Ordinateur
import retrofit2.http.GET

interface PcApiService {
    @GET(Constante.API_ENDPOINT)
    suspend fun getAll():List<Ordinateur>
}