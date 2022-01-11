package com.example.proyectorecu.Clases

import androidx.room.*
import kotlinx.coroutines.flow.Flow

interface PeliculaDao {

    @Query("SELECT * FROM pelicula_table ORDER BY nombre ASC")
    fun getAlphabetizedPeliculas(): Flow<List<Pelicula>>

    @Query("SELECT * FROM pelicula_table ORDER BY director ASC")
    fun getAlphabetizedPeliculas2(): List<Pelicula>

    @Query("SELECT * from pelicula_table where id like :id")
    fun buscarPorId(id: Int): Flow<Pelicula>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(miPelicula: Pelicula)

    @Query("DELETE FROM pelicula_table")
    suspend fun deleteAll()

    @Delete
    suspend fun borrar(miPelicula: Pelicula)

    @Update
    suspend fun modificar(miPelicula: Pelicula)
}