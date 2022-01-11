package com.example.proyectorecu

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val datos2: SharedPreferences =
            (activity as MainActivity).getSharedPreferences("datos2", Context.MODE_PRIVATE)
        view.findViewById<Button>(R.id.binsertar).setOnClickListener {
            //datos2.getString("clave", null)
            if (datos2.getString("usuario", null) != null) {
                if (view.findViewById<EditText>(R.id.et_usuario).text.toString().isNotEmpty()
                    && view.findViewById<EditText>(R.id.et_contraseya).text.toString().isNotEmpty()
                    && datos2.getString(
                        "usuario",
                        "erroneous user"
                    ) == view.findViewById<EditText>(R.id.et_usuario).text.toString()
                    && datos2.getString(
                        "clave",
                        "erroneous password"
                    ) == view.findViewById<EditText>(R.id.et_contraseya).text.toString()
                ) {
                    findNavController().navigate(R.id.action_firstFragment_to_passwordFragment)
                } else {
                    Toast.makeText(activity, "Usuario y clave erróneas\n Inténtalo de nuevo", Toast.LENGTH_SHORT).show()
                }
            } else {
                if (view.findViewById<EditText>(R.id.et_usuario).text.toString().isNotEmpty()
                    && view.findViewById<EditText>(R.id.et_contraseya).text.toString().isNotEmpty()
                ) {
                    var editor2: SharedPreferences.Editor = datos2.edit()
                    editor2.putString(
                        "usuario",
                        view.findViewById<EditText>(R.id.et_usuario).text.toString()
                    )
                    editor2.putString(
                        "clave",
                        view.findViewById<EditText>(R.id.et_contraseya).text.toString()
                    )
                    editor2.apply()
                    Toast.makeText(activity, "Usuario creado", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(activity, "Registrate antes de comenzar", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

}