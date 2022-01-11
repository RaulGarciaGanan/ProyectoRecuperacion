package com.example.proyectorecu.Clases

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class UsuarioRepository (private val miDao: UsuarioDao) {
    val listaUsuarios: Flow<List<Usuario>> = miDao.getAlphabetizedUsuario()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(miUsuario: Usuario) {
        miDao.insert(miUsuario)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun borrar(miUsuario: Usuario) {
        miDao.borrar(miUsuario)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun modificar(miUsuario: Usuario) {
        miDao.modificar(miUsuario)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun buscarPorId(id:Int): Flow<Usuario> {
        return miDao.buscarPorId(id)
    }
}