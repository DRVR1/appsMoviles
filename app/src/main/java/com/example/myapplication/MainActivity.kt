package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Manejo de padding para los insets del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a los inputs y el botón
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<TextView>(R.id.textView3) // Boton de ir al formulario de registro
        btnRegister.setOnClickListener(){
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        // Acción del botón
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // DEPURACION (descomentar las lineas para entrar sin iniciar sesion y probar las cosas mas rapido)
//            val intent = Intent(this, Bienvenida::class.java)
//            intent.putExtra("username", username)
//            startActivity(intent)
            // FIN DEPURACION

            // Aquí podrías validar credenciales si querés
            //“Juan Torres” y la clave
            //"1234utn"
            val usuario = arrayOf("Juan Torres", "1234utn")
            if(usuario[0] == username && usuario[1] == password){
                val intent = Intent(this, Bienvenida::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
        val btnToggleTheme = findViewById<Switch>(R.id.switch1)
        btnToggleTheme.setOnClickListener {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate() // Reinicia la Activity para aplicar cambios
        }

    }
}
