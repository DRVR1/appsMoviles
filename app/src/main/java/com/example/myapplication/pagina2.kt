package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pagina2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.pagina2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        // val radioOtra  = findViewById<RadioButton>(R.id.radioButton6)
        val label       = findViewById<TextView>(R.id.LabelEspecifique)
        val editText    = findViewById<EditText>(R.id.editTextOtra)

        val imgAndroid = findViewById<ImageView>(R.id.imgAndroid)
        val imgIos = findViewById<ImageView>(R.id.imgIos)
        imgAndroid.setOnClickListener {
            Toast.makeText(this, "Elegiste Android", Toast.LENGTH_SHORT).show()
        }

        imgIos.setOnClickListener {
            Toast.makeText(this, "Elegiste iOS", Toast.LENGTH_SHORT).show()
        }

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val mostrar = checkedId == R.id.radioButton6
            // visibilidad
            label.visibility = if (mostrar) View.VISIBLE else View.GONE
            editText.visibility = if (mostrar) View.VISIBLE else View.GONE
            // habilitar o no
            editText.isEnabled = mostrar
            if (!mostrar) {
                editText.text.clear()
            }
        }
    }
}