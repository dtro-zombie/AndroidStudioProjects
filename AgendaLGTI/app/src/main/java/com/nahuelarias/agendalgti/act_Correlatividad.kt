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
import java.io.File

class act_Correlatividad : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("WrongViewCast")
    @Suppress("LocalVariableName")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_correlatividad)


        var Cod= getcodigo()
        val listaProductos = getMaterias()
        //retorna materia
        var producto= retornarmateria(Cod)
        var listacorrelativas = mutableListOf<String>()
        var i=0
        var listamateriascorrelatiovas = mutableListOf<Materias>()
        i = 0
        listaProductos.forEach { _ ->
            var unamateria = listaProductos[i]
                if(producto.Correlativa1==unamateria.Codigo||producto.Correlativa2==unamateria.Codigo||producto.Correlativa3==unamateria.Codigo||producto.Correlativa4==unamateria.Codigo)
                    {
                        listamateriascorrelatiovas.add(unamateria)
                    }
            i++

        }

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
                 setcodigo(codigomateria1.Codigo)
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


                    sobreescribir(listaProductos)
                    Thread.sleep(1000)


                    Toast.makeText(this, " APROBADO  ", Toast.LENGTH_SHORT).show()


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
                sobreescribir(listaProductos)


                Thread.sleep(1000)
                Toast.makeText(this, " se saco el aprobado ", Toast.LENGTH_SHORT).show()
                }

        }





        }

    private fun sobreescribir(listaProductos: MutableList<Materias>) {


      //  var inputStream =
        //    resources.openRawResource(resources.getIdentifier("data", "raw", packageName)).




        val outString = listaProductos
        File("src/test/java/data").bufferedWriter().use { out -> out.write(outString.toString()) }

        //inputStream
    }





    }




