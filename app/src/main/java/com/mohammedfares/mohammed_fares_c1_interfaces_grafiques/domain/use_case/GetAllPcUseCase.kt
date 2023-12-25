package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.use_case

import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.comon.Resource
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.data.repository.RemoteRepository
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model.Ordinateur
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model.OrdinateurLikebale
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model.toLiked
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model.toNotLiked
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllPcUseCase @Inject constructor(
    val repository: RemoteRepository
) {
    operator fun invoke(): Flow<Resource<List<OrdinateurLikebale>>> = flow {
        emit(Resource.Loading())
        try {

            val ordinateurLocal = emptyList<String>()

            val ordinateurs: List<OrdinateurLikebale> = repository.getAll().map {
                if (ordinateurLocal.contains(it.nom)) {
                    it.toLiked()
                } else {
                    it.toNotLiked()
                }
            }

            if (ordinateurs.isNotEmpty()) {
                emit(Resource.Success(ordinateurs))
            } else {
                emit(Resource.Error("empty"))
            }

        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}