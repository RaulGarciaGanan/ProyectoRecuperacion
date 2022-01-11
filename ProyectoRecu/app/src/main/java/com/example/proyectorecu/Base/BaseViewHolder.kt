package com.example.ejercicio_14.Base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

//Esta clase es una extensión cuando cuando creemos el adaptador del RecyclerView
abstract class BaseViewHolder<T>(v: View) : RecyclerView.ViewHolder(v) {



    abstract  fun bind(item: T, position: Int)
}