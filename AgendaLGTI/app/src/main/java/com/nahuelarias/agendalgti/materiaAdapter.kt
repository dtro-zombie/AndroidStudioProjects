package com.nahuelarias.agendalgti

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_materia.view.*

class materiaAdapter(private val mContext: Context, private val listaProductos: MutableList<Materias>) : ArrayAdapter<Materias>(mContext, 0, listaProductos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_materia, parent, false)



        val producto = listaProductos[position]

        layout.codigo.text = producto.Codigo
        layout.materia.text = producto.Materia


        if(producto.Aprobada == "false") {
           // FFFFAB91
            layout.Contenedocolor.setBackgroundColor(4294945681.toInt())
        }else{
            //FFA5D6A7
            layout.Contenedocolor.setBackgroundColor(4289058471.toInt())

        }
        return layout
    }
}