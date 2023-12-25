package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ordinateur(
    val date_fin_os: String,
    val image: String,
    @PrimaryKey
    val nom: String,
    val prix: String,
    val systeme_exploitation: String
)


fun Ordinateur.toLiked (): OrdinateurLikebale {
    return OrdinateurLikebale(
        ordinateur = this,
        isLiked = true
    )
}

fun Ordinateur.toNotLiked(): OrdinateurLikebale {
    return OrdinateurLikebale(
        ordinateur = this,
        isLiked = false
    )
}