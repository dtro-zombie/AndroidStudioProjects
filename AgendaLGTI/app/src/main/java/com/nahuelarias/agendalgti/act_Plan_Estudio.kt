package com.nahuelarias.agendalgti

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_correlatividad.*
import kotlinx.android.synthetic.main.activity_act_plan_estudio.*
import kotlinx.android.synthetic.main.item_materia.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream


class act_Plan_Estudio : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_plan_estudio)

        val text = mutableListOf<String>()


val filepath="/data/data/com.nahuelarias.myapplication/files/files/data.txt"

        val f: File = File(filepath)
        if (f.exists() == true) {

            Log.e(TAG, "Valid :$filepath")
        }

        else {

            crearachivo()

            Log.e(TAG, "InValid :$filepath")
        }




        var miArchivo= File("/data/data/com.nahuelarias.myapplication/files/files/data.txt")

        val contenido = miArchivo.readText()

        val lineas = miArchivo.readLines()

        lineas.forEach { println(it) } // muestra todo el archivo

        val lineasLista = mutableListOf<String>()
        miArchivo.useLines { lines -> lines.forEach { text.add(it) } }

        var materiasa = mutableListOf<Materias>()
            materiasa = txtsplit(text)


        setMaterias(materiasa)

            materiasa.forEach {
                val adapter = materiaAdapter(this, materiasa)

                listaplan.adapter = adapter

            }

            this.listaplan.onItemClickListener =
                AdapterView.OnItemClickListener { parent, view, position, id ->

                    val intent: Intent =
                        Intent(this@act_Plan_Estudio, act_Correlatividad::class.java)
                    var codigomateria1 = materiasa.get(position)

                    setcodigo(codigomateria1.Codigo)

                    startActivity(intent)

                }


        }
        fun crearachivo() {
            try {


                val newFileName = "data.txt"


               val nuevaCarpeta = File(filesDir, "files")
                nuevaCarpeta.mkdirs()


                //Obtiene archivo de directorio /raw
                val inputStream:InputStream = resources.openRawResource(R.raw.data)
                //Lee contenido de archivo
                val inputString = inputStream.bufferedReader().use{it.readText()}

                //Define y crea archivo
                var myInternalFile:File = File(nuevaCarpeta,newFileName)
                myInternalFile.createNewFile()


                try {
                    val fileOutPutStream = FileOutputStream(myInternalFile)
                    //Guarda contenido en archivo
                    fileOutPutStream.write(inputString.toByteArray())
                    fileOutPutStream.close()
                } catch (e: IOException) {
                    Log.d(TAG, "IOException " + e.message)
                }


            } catch (e:Exception){
                Log.d(TAG, "Exception : " + e.toString())
            }

        }

        }










