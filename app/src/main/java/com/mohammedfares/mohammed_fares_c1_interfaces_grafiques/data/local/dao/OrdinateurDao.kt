package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.domain.model.Ordinateur
import kotlinx.coroutines.flow.Flow

@Dao
interface OrdinateurDao {

    @Insert
    suspend fun insert(ordinateur: Ordinateur): Long

    @Delete
    suspend fun delete (ordinateur: Ordinateur): Int

    @Query("SELECT COUNT(*) FROM ordinateur")
    suspend fun count(): Flow<Int>

    @Query("SELECT * FROM ordinateur")
    suspend fun getAll(): List<Ordinateur>
}