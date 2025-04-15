package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSendRegister = findViewById<Button>(R.id.btnSendRegister)

        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val editTextRePassword = findViewById<EditText>(R.id.editTextTextPassword2)

        btnSendRegister.setOnClickListener(){
            var exito = true
            // nombre no debe estar vacio
            val nombre = editTextNombre.text.toString()
            if(nombre.isEmpty()){
                Toast.makeText(this,"Nombre no debe estar vacio",Toast.LENGTH_SHORT).show()
                exito = false
                return@setOnClickListener
            }
            // email no debe estar vacio
            val email = editTextEmail.text.toString()
            if(email.isEmpty()){
                Toast.makeText(this,"Email no debe estar vacio",Toast.LENGTH_SHORT).show()
                exito = false
                return@setOnClickListener
            }
            // la contraseña debe ser mayor o igual a 6 caracteres
            val password = editTextPassword.text.toString()
            if(password.length < 6){
                Toast.makeText(this,"La contraseña debe ser mayor o igual a 6 caracteres",Toast.LENGTH_SHORT).show()
                exito = false
                return@setOnClickListener
            }
            // ambas contraseñas deben ser iguales
            val rePassword = editTextRePassword.text.toString()
            if(!password.equals(rePassword)){
                Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show()
                exito = false
                return@setOnClickListener
            }
            // si la validacion es correcta, retornar al login
            if(exito){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        //agrego esto para volver al inicio de sesion
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra la Activity actual para no acumularlas
        }
    }
}