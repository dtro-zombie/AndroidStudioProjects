package com.nahuelarias.agendalgti

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_correlatividad.*
import kotlinx.android.synthetic.main.activity_act_plan_estudio.*
import kotlinx.android.synthetic.main.item_materia.*

class act_Correlatividad : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("WrongViewCast")
    @Suppress("LocalVariableName")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_correlatividad)


        var Cod= getcodigo()



        println("2013")


        println(Cod)


        val listaProductos = getMaterias()


        //retorna materia





            var producto= retornarmateria(Cod)





        println("holllllllaaaaaaaaaa"+producto.Materia)
        println("holllllllaaaaaaaaaa"+producto.Codigo)

            var listacorrelativas = mutableListOf<String>()


        var i=0



        var listamateriascorrelatiovas = mutableListOf<Materias>()
        i = 0
        listaProductos.forEach { _ ->
            println("holllllllaaaaaaaaaa"+producto.Materia)
            println("holllllllaaaaaaaaaa"+producto.Codigo)

            var unamateria = listaProductos[i]


            if(producto.Correlativa1==unamateria.Codigo||producto.Correlativa2==unamateria.Codigo||producto.Correlativa3==unamateria.Codigo||producto.Correlativa4==unamateria.Codigo)
            {
                listamateriascorrelatiovas.add(unamateria)
            }


            i++




        }

        println("holllllllaaaaaaaaaa"+producto.Materia)
        println("holllllllaaaaaaaaaa"+producto.Codigo)
        Materiamostrar.text = "Para cursar "+producto.Materia+" de "+ producto.Anio + "año nesecitas"


         i=0
        listamateriascorrelatiovas.forEach {


                val adapter = materiaAdapter(this, listamateriascorrelatiovas)



                listacorrelatividad.adapter = adapter
                i++
            }

        if(producto.Aprobada=="true") {
            swt_aprobado.toggle()
        }


        this.listacorrelatividad.onItemClickListener =

            AdapterView.OnItemClickListener { parent, view, position, id ->

                var codigomateria1 = listamateriascorrelatiovas.get(position)
                var codigomateria = setcodigo(codigomateria1.Codigo)
                println("codigooooooo2")
                println(position)
                println(codigomateria)
                val intent: Intent = Intent(this@act_Correlatividad,act_Correlatividad::class.java)
                startActivity(intent)

            }






        swt_aprobado.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
            {

                i=0
                var cont=0
                        listamateriascorrelatiovas.forEach {
                           var aprobadas = listamateriascorrelatiovas[i]

                            if(aprobadas.Aprobada=="true")
                            {
                                cont++




                            }
                                i++
                        }
                if (listamateriascorrelatiovas.size == cont || listamateriascorrelatiovas.size == 0 )
                {
                    i=0
                    listaProductos.forEach {

                        if(listaProductos[i].Codigo==Cod)
                        {
                            listaProductos[i].Aprobada="true"
                        }
                        i++
                    }

                    setMaterias(listaProductos)

                        listacorrelatividad.deferNotifyDataSetChanged()

                    Toast.makeText(this, " APROBADO  ", Toast.LENGTH_SHORT).show()


                    i=0
                        listaProductos.forEach {

                            var mostrar = listaProductos[i]

                            println(mostrar.Materia)
                            println(mostrar.Aprobada)
                                i++
                        }


                }else{
                    Toast.makeText(this, "Debe aprobar las correlativas primero", Toast.LENGTH_SHORT).show()
                    swt_aprobado.toggle()
                }

            }



            else
            {
                i=0
                listaProductos.forEach {



                    if(listaProductos[i].Codigo==Cod)
                    {
                        listaProductos[i].Aprobada= "false"
                    }

                    i++
                }




                setMaterias(listaProductos)

                listacorrelatividad.deferNotifyDataSetChanged()
                Toast.makeText(this, " se saco el aprobado", Toast.LENGTH_SHORT).show()




            }


            fun sobreescribir()
            {

            }

        }






    }





}


