package com.example.laboratorio1danp

import androidx.room.Dao
import androidx.room.*
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow


@Dao
interface AsistenteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsistente(asistente: Asistente)

    @Query("SELECT * FROM asistente")
    fun getAllAsistente(): Flow<List<Asistente>>

    @Delete
    suspend fun deleteAsistente(asistente: Asistente)



}