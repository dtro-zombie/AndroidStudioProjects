package com.nahuelarias.agendalgti

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_correlatividad.*
import java.io.File

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


        swt_aprobado.setOnCheckedChangeListener { _ ,isChecked->
            var i =0
            var cont = 0

            if(isChecked)
            {



                                                producto.Aprobada="true"
                                                var temp=producto

                                                listaProductos.remove(producto)
                                                listaProductos.add(temp)


                var materiastexto : MutableList<Materias>
                                                    listaProductos.forEach {

                                                        materiastexto.add(listaProductos[1])  }


                                                val outString = listaProductos

                                                File("src/main/res/raw/data.txt").printWriter().use { out -> out.println(outString) }
                                                Toast.makeText(this, "FELICIDADES UNA MAS,FALTA MENOS!!! ", Toast.LENGTH_SHORT).show()






            }else{

                Toast.makeText(this, "TENES QUE APROBAR CORRELATIVAS!!", Toast.LENGTH_SHORT).show()

            }



        }







    }





}


