package com.example.appunabandreanunez

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    private lateinit var Nombre: EditText
    private lateinit var etp_pass: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        Nombre = findViewById(R.id.Nombre)
        etp_pass = findViewById(R.id.Edad)
    }

    fun login(Vista: View) {
        var nombre = Nombre.text.toString()
        var pass = etp_pass.text.toString()

        if (nombre.length == 0){
            Toast.makeText(this, "Debes escribir tu nombre", Toast.LENGTH_SHORT).show()
        }

        if (pass.length == 0) {
            Toast.makeText(this, "Debes escribir tu contraseña", Toast.LENGTH_SHORT).show()
        }

        if (nombre.length != 0 && pass.length != 0) {
            Toast.makeText(this, "Bienvenido $nombre", Toast.LENGTH_SHORT).show()
            val newVentana: Intent = Intent(this, MainActivity2::class.java)
            startActivity(newVentana)
            Nombre.setText("")
            etp_pass.setText("")
        }
        else{
            Toast.makeText(this, "Tu usuario o contraseña son incorrectos", Toast.LENGTH_SHORT).show()
        }
    }
}