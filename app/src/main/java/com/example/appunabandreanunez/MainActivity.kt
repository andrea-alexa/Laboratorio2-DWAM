package com.example.appunabandreanunez

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    lateinit var Nombre: EditText
    lateinit var Edad: EditText
    lateinit var Departamento: EditText
    lateinit var btnAgregar: Button
    lateinit var Lista: ListView
    lateinit var tvDetalle: TextView

    val listaUsuarios = ArrayList<Usuario>()
    val listaNombres = ArrayList<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Nombre = findViewById(R.id.Nombre)
        Edad = findViewById(R.id.Edad)
        Departamento = findViewById(R.id.Departamento)
        btnAgregar = findViewById(R.id.btnAgregar)
        Lista = findViewById(R.id.Lista)
        tvDetalle = findViewById(R.id.tvDetalle)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNombres)
        Lista.adapter = adapter

        btnAgregar.setOnClickListener {

            val nombre = Nombre.text.toString()
            val edad = Edad.text.toString()
            val departamento = Departamento.text.toString()

            if (nombre.isEmpty() || edad.isEmpty() || departamento.isEmpty()) {
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val usuario = Usuario(nombre, edad, departamento)

                listaUsuarios.add(usuario)
                listaNombres.add(nombre)

                adapter.notifyDataSetChanged()

                // Limpiar campos
                Nombre.text.clear()
                Edad.text.clear()
                Departamento.text.clear()
            }
        }

        Lista.setOnItemClickListener { _, _, position, _ ->

            val usuarioSeleccionado = listaUsuarios[position]

            tvDetalle.text = "Edad: ${usuarioSeleccionado.edad}\nDepartamento: ${usuarioSeleccionado.departamento}"
        }
    }
}