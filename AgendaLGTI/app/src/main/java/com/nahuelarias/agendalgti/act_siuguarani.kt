package com.nahuelarias.agendalgti

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act_siuguarani.*


class act_siuguarani : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var bundle= intent.extras
        var stringUrl = bundle?.getString("dt").toString()


        setContentView(R.layout.activity_act_siuguarani)
        // webView
        webView.webChromeClient = object : WebChromeClient(){

        }
        webView.webViewClient = object : WebViewClient(){



        }

        val settings:WebSettings = webView.settings
        settings.javaScriptEnabled=true
            webView.loadUrl(stringUrl)

    }

    override fun onBackPressed() = if(webView.canGoBack()){
        webView.goBack()
    }else{
        super.onBackPressed()
    }



}