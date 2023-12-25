package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.di

import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.comon.Constante
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.data.remote.api.PcApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModul {



    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =  Retrofit.Builder()
        .baseUrl(Constante.API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    @Singleton
    fun providePcApiService(retrofit: Retrofit): PcApiService = retrofit.create(PcApiService::class.java)
}