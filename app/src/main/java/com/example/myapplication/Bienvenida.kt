package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.pagina2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imgAndroid = findViewById<ImageView>(R.id.imgAndroid)
        val imgIos = findViewById<ImageView>(R.id.imgIos)
        imgAndroid.setOnClickListener {
            Toast.makeText(this, "Elegiste Android", Toast.LENGTH_SHORT).show()
            imgAndroid.setBackgroundResource(R.drawable.borde_seleccionado)
            imgIos.setBackgroundResource(0)
        }

        imgIos.setOnClickListener {
            Toast.makeText(this, "Elegiste iOS", Toast.LENGTH_SHORT).show()
            imgIos.setBackgroundResource(R.drawable.borde_seleccionado)
            imgAndroid.setBackgroundResource(0)
        }
        //este boton es para "salir" de la vista iniciada de sesion
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra la Activity actual para no acumularlas
        }
    }
}