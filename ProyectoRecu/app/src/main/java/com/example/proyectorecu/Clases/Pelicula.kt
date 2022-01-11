package com.example.proyectorecu.Clases

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pelicula_table")
class Pelicula(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @NonNull @ColumnInfo(name = "nombre") var nombre: String,
    @NonNull @ColumnInfo(name = "director") var director: String,

) {
}