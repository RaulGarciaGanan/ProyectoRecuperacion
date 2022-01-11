package com.example.proyectorecu.Clases

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario_table")
data class Usuario (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @NonNull @ColumnInfo(name = "nombre") var nombre: String,
    @NonNull @ColumnInfo(name = "contrasena") var contrasena: String,
        ) {
}