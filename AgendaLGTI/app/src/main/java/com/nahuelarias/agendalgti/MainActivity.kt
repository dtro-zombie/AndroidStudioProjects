package com.nahuelarias.agendalgti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_plan_estudio.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        this.btnsiu.setOnClickListener {
            val intent =Intent(this@MainActivity,act_siuguarani::class.java)
            val dato = "https://estudiantes.unpaz.edu.ar/autogestion/acceso/login?ref=http://estudiantes.unpaz.edu.ar/autogestion/requisitos_ingreso\")\n"
            val b = Bundle()
            b.putString("dt",dato)
            intent.putExtras(b)
            startActivity(intent)

        }


        this.btncampusvirtual.setOnClickListener {
            val intent =Intent(this@MainActivity,act_siuguarani::class.java)
            val dato = "https://campusvirtual.unpaz.edu.ar/login/index.php"
            val b = Bundle()
            b.putString("dt",dato)
            intent.putExtras(b)
            startActivity(intent)

        }

        this.btnplan.setOnClickListener {

            val intent = Intent(this,act_Plan_Estudio::class.java)
            startActivity(intent)

        }
    }
}