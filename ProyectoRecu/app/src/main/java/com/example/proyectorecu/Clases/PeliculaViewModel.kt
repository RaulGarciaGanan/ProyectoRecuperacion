package com.example.proyectorecu.Clases

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class PeliculaViewModel (private val miRepositorio: PeliculaRepository) : ViewModel(){
    val listaPeliculas: LiveData<List<Pelicula>> = miRepositorio.listaPelicula.asLiveData()
    lateinit var miPelicula: LiveData<Pelicula>

    fun insert(miPelicula: Pelicula) = viewModelScope.launch {
        miRepositorio.insert(miPelicula)
    }

    fun modificar(miPelicula: Pelicula) = viewModelScope.launch {
        miRepositorio.modificar(miPelicula)
    }

    fun borrar(miPelicula: Pelicula) = viewModelScope.launch {
        miRepositorio.borrar(miPelicula)
    }

    //Esta función me devuelve un Flow que guardo en la variable que he creado antes
    fun buscarPorId(id: Int) = viewModelScope.launch {
        miPelicula = miRepositorio.buscarPorId(id).asLiveData()
    }


    class PeliculaViewModelFactory(private val myRepository: PeliculaRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PeliculaViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PeliculaViewModel(myRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}