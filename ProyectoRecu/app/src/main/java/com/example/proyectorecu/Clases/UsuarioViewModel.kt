package com.example.proyectorecu.Clases

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class UsuarioViewModel(private val miRepositorio: UsuarioRepository) : ViewModel() {
    val listaUsuarios: LiveData<List<Usuario>> = miRepositorio.listaUsuarios.asLiveData()
    lateinit var miUsuario: LiveData<Usuario>

    fun insert(miUsuario: Usuario) = viewModelScope.launch {
        miRepositorio.insert(miUsuario)
    }

    fun modificar(miUsuario: Usuario) = viewModelScope.launch {
        miRepositorio.modificar(miUsuario)
    }

    fun borrar(miUsuario: Usuario) = viewModelScope.launch {
        miRepositorio.borrar(miUsuario)
    }

    //Esta función me devuelve un Flow que guardo en la variable que he creado antes
    fun buscarPorId(id: Int) = viewModelScope.launch {
        miUsuario = miRepositorio.buscarPorId(id).asLiveData()
    }


    class UsuarioViewModelFactory(private val myRepository: PeliculaRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PeliculaViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PeliculaViewModel(myRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}