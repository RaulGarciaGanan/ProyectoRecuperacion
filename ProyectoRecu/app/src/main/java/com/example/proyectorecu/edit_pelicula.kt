package com.example.proyectorecu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.proyectorecu.Clases.Pelicula

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [edit_pelicula.newInstance] factory method to
 * create an instance of this fragment.
 */
class edit_pelicula : Fragment() {

    var posicion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_pelicula, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bInsertar = view.findViewById<Button>(R.id.binsertar)
        val bBorrar = view.findViewById<Button>(R.id.bBorrar)
        val bModificar = view.findViewById<Button>(R.id.bmodificar)
        val etPelicula = view.findViewById<EditText>(R.id.et_nombre_Pelicula)
        val etDirector = view.findViewById<EditText>(R.id.et_nombre_director)
        val tvId = view.findViewById<TextView>(R.id.tv_id)
        posicion = arguments?.getInt("id") ?: -1
        var peli: Pelicula = Pelicula(posicion,"","")


        if (posicion == -1) {
            bBorrar.isEnabled = false
            bModificar.isEnabled = false
            bInsertar.isEnabled = true
            activity?.setTitle("Insertar tarea")
        } else {
            bBorrar.isEnabled = true
            bModificar.isEnabled = true
            bInsertar.isEnabled = false
            activity?.setTitle("Modificar/Borrar tareas")
            peli = (activity as MainActivity).miViewModel.dataset[posicion]
            tvId.text = String.format("ID: $posicion")
            etPelicula.setText(peli.nombre)
            etDirector.setText(peli.director)
        }

        bInsertar.setOnClickListener() {
            if (etPelicula.text.isEmpty()) {
                Toast.makeText(
                    (activity as MainActivity),
                    "Tarea vacía. Rellena el campo",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                (activity as MainActivity).miViewModel.insertar(

                )
                findNavController().navigate(R.id.action_edit_pelicula_to_pelicula)
            }
        }

        bBorrar.setOnClickListener() {
            (activity as MainActivity).miViewModel.borrar(posicion)
            findNavController().navigate(R.id.action_edit_pelicula_to_pelicula)
        }

        bModificar.setOnClickListener() {
            if (peli.nombre == etPelicula.text.toString()) {
                Toast.makeText(
                    (activity as MainActivity),
                    "Tarea no modificada",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                (activity as MainActivity).miViewModel.modificar(

                )
                findNavController().navigate(R.id.action_edit_pelicula_to_pelicula)
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment edit_pelicula.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            edit_pelicula().apply {
                arguments = Bundle().apply {

                }
            }
    }
}