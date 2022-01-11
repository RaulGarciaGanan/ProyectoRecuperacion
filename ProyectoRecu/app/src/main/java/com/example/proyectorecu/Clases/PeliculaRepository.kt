package com.example.proyectorecu.Clases

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class PeliculaRepository (private val miDao: PeliculaDao){
    val listaPelicula: Flow<List<Pelicula>> = miDao.getAlphabetizedPeliculas()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(miPelicula: Pelicula) {
        miDao.insert(miPelicula)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun borrar(miPelicula: Pelicula) {
        miDao.borrar(miPelicula)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun modificar(miPelicula: Pelicula) {
        miDao.modificar(miPelicula)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun buscarPorId(id:Int):Flow<Pelicula> {
        return miDao.buscarPorId(id)
    }
}