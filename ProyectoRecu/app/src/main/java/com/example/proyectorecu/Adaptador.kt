package com.example.proyectorecu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectorecu.Clases.Pelicula

class Adaptador(var listaPeliculas:MutableList<Pelicula>): RecyclerView.Adapter<Adaptador.ViewHolder>() {

    inner class  ViewHolder(v: View):RecyclerView.ViewHolder(v){
        val tvNombrePelicula:EditText
        val etDirector:EditText
        var posicion: Int

        init {
            tvNombrePelicula = v.findViewById(R.id.et_nombre_Pelicula)
            etDirector = v.findViewById(R.id.et_nombre_director)
            posicion = 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from (parent.context).inflate(R.layout.toolbar,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = listaPeliculas[position]
        //Problema con el tipo de cambio de datos
        //holder.tvNombrePelicula.text = pelicula.nombre
        //holder.etDirector.text = pelicula.director
        holder.posicion = position
    }

    override fun getItemCount(): Int {
        return listaPeliculas.size
    }
}