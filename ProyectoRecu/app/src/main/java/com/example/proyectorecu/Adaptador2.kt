package com.example.proyectorecu

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio_14.Base.BaseViewHolder
import com.example.proyectorecu.Clases.Pelicula
import java.lang.IllegalArgumentException

class Adaptador2(
    private val context: Activity,
    val peliculasList: List<Pelicula>?
) : RecyclerView.Adapter<BaseViewHolder<*>>() {
    private val typePelicula: Int = 1

    override fun getItemViewType(position: Int): Int {
        var itemview: Int

        itemview = typePelicula

        return itemview
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {


        return PeliculaViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_contenedor2, parent, false)
        )
    }

    inner class PeliculaViewHolder(itemView: View) : BaseViewHolder<Pelicula>(itemView) {

        override fun bind(item: Pelicula, position: Int) {
            itemView.findViewById<TextView>(R.id.tvwNombre).text = item.nombre
            itemView.findViewById<TextView>(R.id.tvwDirector).text = item.director


            //Gestionamos la opción onClick para cada elemento holder del RecyclerView

            itemView.findViewById<TextView>(R.id.tvwNombre).setOnClickListener {
                //itemClickListener.onItemClick(item.nombre)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is PeliculaViewHolder -> peliculasList?.get(position)?.let { holder.bind(it, position) }

            //holder.posicion=position

            else -> IllegalArgumentException("Se olvidó de pasar el viewHolder en el bind")
        }
    }

    override fun getItemCount(): Int {

        var tamanyo: Int = 0
        if (peliculasList != null) {
            tamanyo = peliculasList.size
        }


        return tamanyo
    }

    /*Usaremos interfaces: El lugar donde implementamos este interfaz
    recibe información para que haga algún tipo de tarea*/
    interface OnItemClickListener {
        fun onImageClick(imagen: String)
        fun onItemClick(titulo: String)
    }
}






