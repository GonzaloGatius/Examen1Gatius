package com.example.examen1gatius

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InicioActivity : AppCompatActivity() {

    private lateinit var editTextIngresoNombre: EditText
    private lateinit var buttonIngresoToList : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        editTextIngresoNombre = findViewById(R.id.editTextIngresoName)
        buttonIngresoToList = findViewById(R.id.buttonToList)

        buttonIngresoToList.setOnClickListener {
            if (editTextIngresoNombre.text.isNullOrEmpty())
                {
                    Toast.makeText(this,"Ingrese un nombre", Toast.LENGTH_LONG).show()
                }
            else
                {
                    val userName = editTextIngresoNombre.text.toString()

                    val preferences = getSharedPreferences("InicioPref", MODE_PRIVATE)
                    val editor = preferences.edit()
                    editor.putString("name", userName)
                    editor.apply()

                    val intent = Intent (this, MainActivity::class.java)
                    intent.putExtra("name", userName) //??????????????????????????????
                    startActivity(intent)
                }
        }
    }
}