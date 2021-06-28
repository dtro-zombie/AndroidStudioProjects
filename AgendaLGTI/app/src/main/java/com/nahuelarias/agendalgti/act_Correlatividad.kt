package com.nahuelarias.agendalgti

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_correlatividad.*

class act_Correlatividad : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("WrongViewCast")
    @Suppress("LocalVariableName")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_correlatividad)



        var bundle= intent.extras
        var Pos= bundle?.getInt("dt")
        val listaProductos = getMaterias()
        val producto = listaProductos[Pos as Int]




        var listacorrelativas = mutableListOf<String>()




        var listamateriascorrelatiovas = mutableListOf<Materias>()
        var i:Int = 0
        listaProductos.forEach {



                var unamateria = listaProductos[i]

            if(producto.Correlativa1==unamateria.Codigo||producto.Correlativa2==unamateria.Codigo||producto.Correlativa3==unamateria.Codigo||producto.Correlativa4==unamateria.Codigo)
            {
                listamateriascorrelatiovas.add(unamateria)
            }


            i++




        }

        Materiamostrar.text = "Para cursar "+producto.Materia+" de "+ producto.Anio + "año nesecitas"

        listamateriascorrelatiovas.forEach {
            val adapter = materiaAdapter(this, listamateriascorrelatiovas)

            listacorrelatividad.adapter = adapter

        }








    }





}


