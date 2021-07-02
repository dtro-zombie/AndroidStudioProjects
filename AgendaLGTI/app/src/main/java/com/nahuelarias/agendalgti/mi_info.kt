package com.nahuelarias.agendalgti

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mi_info.*


class mi_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_info)



        this.btnlinkeding.setOnClickListener{

            try {
                val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/nahuel-ariasz/"))
                startActivity(myIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    this, "no se recibio repuesta de la aplicacion."
                            + " Porfavor instale un navegador", Toast.LENGTH_LONG
                ).show()
                e.printStackTrace()
            }
        }

        this.btninstagram.setOnClickListener{

            try {
                val myIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/Nahu.Arias1/"))
                startActivity(myIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    this, "no se recibio repuesta de la aplicacion."
                            + " Porfavor instale un navegador", Toast.LENGTH_LONG
                ).show()
                e.printStackTrace()
            }
        }


    }
}