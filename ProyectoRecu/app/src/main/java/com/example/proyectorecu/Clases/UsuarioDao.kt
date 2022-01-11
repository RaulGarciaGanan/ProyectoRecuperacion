package com.example.proyectorecu.Clases

import androidx.room.*
import kotlinx.coroutines.flow.Flow

interface UsuarioDao {
    @Query("SELECT * FROM usuario_table ORDER BY nombre ASC")
    fun getAlphabetizedUsuario(): Flow<List<Usuario>>

    @Query("SELECT * FROM usuario_table ORDER BY contrasena ASC")
    fun getAlphabetizedUsuario2(): List<Usuario>

    @Query("SELECT * from usuario_table where id like :id")
    fun buscarPorId(id: Int): Flow<Usuario>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(miUsuario: Usuario)

    @Query("DELETE FROM usuario_table")
    suspend fun deleteAll()

    @Delete
    suspend fun borrar(miUsuario: Usuario)

    @Update
    suspend fun modificar(miUsuario: Usuario)
}