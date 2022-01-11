package com.example.proyectorecu

import androidx.lifecycle.ViewModel
import com.example.proyectorecu.Clases.Pelicula

class VM : ViewModel() {
    var dataset: MutableList<Pelicula> = mutableListOf()
    //val peliculaSeleccionada: MutableLiveData<Pelicula> = MutableLiveData()

    init {
        dataset = cargarPeliculas()
    }

    private fun cargarPeliculas(): MutableList<Pelicula> {
        val lista = mutableListOf<Pelicula>()
        lista.add(Pelicula(0,"Avatar","James"))
        lista.add(Pelicula(1,"No es pais para viejos","jon"))
        lista.add(Pelicula(2,"Una noche en paris","charles"))

        return lista
    }

    fun insertar(peli:Pelicula){
        dataset.add(peli)
    }

    fun borrar(posicion:Int){
        dataset.removeAt(posicion)
        //val peliEliminada=dataset.removeAt(posicion).titulo
        //Toast.makeText(this,"Quieres eliminar $peliEliminada ?",Toast.LENGTH_LONG)
    }

    fun modificar(peli:Pelicula, posicion: Int){
        dataset[posicion].nombre=peli.nombre
        dataset[posicion].director=peli.director
    }

    fun insertar() {
        TODO("Not yet implemented")
    }

    fun modificar() {
        TODO("Not yet implemented")
    }
}