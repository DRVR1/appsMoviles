package com.example.tp1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.tp1.ui.theme.Tp1Theme
class MainActivity : ComponentActivity() {
    private var mostrarPagina1 = true // Variable de estado para controlar qué página mostrar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toast("App iniciada", this)
        enableEdgeToEdge()
        cargarPaginaInicial()
    }

    private fun cargarPaginaInicial() {
        setContent {
            Tp1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (mostrarPagina1) {
                        XmlLayoutContent(
                            modifier = Modifier.padding(innerPadding),
                            onIrPagina2 = { irPagina2() }
                        )
                    } else {
                        Pagina2Content(
                            modifier = Modifier.padding(innerPadding),
                            onVolver = { volverAPagina1() }
                        )
                    }
                }
            }
        }
    }

    fun irPagina2() {
        mostrarPagina1 = false
        cargarPaginaActual()
    }

    fun volverAPagina1() {
        mostrarPagina1 = true
        cargarPaginaActual()
    }

    private fun cargarPaginaActual() {
        runOnUiThread {
            cargarPaginaInicial()
        }
    }
}

@Composable
fun XmlLayoutContent(modifier: Modifier = Modifier, onIrPagina2: () -> Unit = {}) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            android.view.LayoutInflater.from(context).inflate(R.layout.primera_pagina, null).apply {
                // Configurar el botón para llamar a la función de navegación
                findViewById<android.widget.Button>(R.id.button1)?.setOnClickListener {
                    onIrPagina2()
                }
            }
        }
    )
}

@Composable
fun Pagina2Content(modifier: Modifier = Modifier, onVolver: () -> Unit = {}) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            android.view.LayoutInflater.from(context).inflate(R.layout.segunda_pagina, null).apply {
                // Configurar el botón de volver
                findViewById<android.widget.Button>(R.id.button2)?.setOnClickListener {
                    onVolver()
                }
            }
        }
    )
}

fun toast(textoAMostrar: String, contexto: Context){
    println("El toast fue llamado con parametro: $textoAMostrar")
    Toast.makeText(contexto, textoAMostrar, Toast.LENGTH_SHORT).show()
}
