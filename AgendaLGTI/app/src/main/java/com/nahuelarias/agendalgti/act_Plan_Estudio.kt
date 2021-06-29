package com.nahuelarias.agendalgti

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_correlatividad.*
import kotlinx.android.synthetic.main.activity_act_plan_estudio.*
import kotlinx.android.synthetic.main.item_materia.*
import java.io.BufferedReader
import java.io.InputStreamReader


class act_Plan_Estudio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_plan_estudio)

        val text= mutableListOf<String>()
        var filename = "data"
        var inputStream =
            resources.openRawResource(resources.getIdentifier(filename, "raw", packageName))


        var inputStreamReader = InputStreamReader(inputStream)
        var bufferedReader = BufferedReader(inputStreamReader)
        //text = bufferedReader.readLine().toString()
        bufferedReader.useLines { texto -> texto.forEach { text.add(it) } }
        text.forEach {

            println("> $it")
        }




        var materiasa = mutableListOf<Materias>()
        materiasa = txtsplit(text)

        setMaterias(materiasa)


        materiasa.forEach {
            val adapter = materiaAdapter(this, materiasa)

            listaplan.adapter = adapter

        }

        this.listaplan.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->




                val selectedItemText = parent.getItemAtPosition(position)

                val intent: Intent = Intent(this@act_Plan_Estudio,act_Correlatividad::class.java)



                var codigomateria1 = materiasa.get(position)

                var codigomateria = setcodigo(codigomateria1.Codigo)
                println("codigooooooo1")
                println(codigomateria)
                startActivity(intent)

            }
    }
}


