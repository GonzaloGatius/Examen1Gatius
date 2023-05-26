package com.example.examen1gatius

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AlumnoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) //va o no va????????????

        val name = intent.getStringExtra("name")

        val adapter = AlumnoAdapter(applicationContext)
        recyclerView.adapter = adapter
        adapter.submitList(getListaAlumnos())

///VINCULAMOS PARA QUE AL TAPEAR VAYA A DETALLES/////////////////////////////////////////////////////////////////////////////////
        adapter.onItemClickListener = { alumno ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", alumno.name)
            intent.putExtra("edad", alumno.age)
            intent.putExtra("url", alumno.url)
            startActivity(intent)


        }
    }
    // NO GUARDA EL SHARED CUANDO VUELVO A ENTRAR
    //"editTextIngresoName" tiene que ser igual al "name" de mi "Alumno"
    private fun getListaAlumnos(): MutableList<Alumno> {
        val preferences = getSharedPreferences("InicioPref", MODE_PRIVATE)
        val userNamePref = preferences.getString("name", "HOLA")
        return mutableListOf(
            Alumno(1, userNamePref.orEmpty() , 22, "https://cdn-icons-png.flaticon.com/512/6075/6075889.png"),
            Alumno(2,"Juan Carlos", 21, "https://cdn-icons-png.flaticon.com/512/1734/1734072.png"),
            Alumno(3,"María", 27, "https://cdn-icons-png.flaticon.com/512/2810/2810758.png"),
            Alumno(4,"Pablo", 29, "https://cdn-icons-png.flaticon.com/512/1754/1754810.png"),
            Alumno(5,"Macarena", 31, "https://cdn-icons-png.flaticon.com/512/2810/2810658.png"),
            Alumno(6,"Guillermo", 22, "https://cdn-icons-png.flaticon.com/512/1754/1754623.png"),
            Alumno(7,"Patricia", 33, "https://cdn-icons-png.flaticon.com/512/2810/2810750.png"),
            Alumno(8,"José", 20, "https://cdn-icons-png.flaticon.com/512/1785/1785918.png"),
            Alumno(9,"Ana María", 26, "https://cdn-icons-png.flaticon.com/512/2810/2810645.png"),
            Alumno(10,"Enrique", 27, "https://cdn-icons-png.flaticon.com/512/1733/1733823.png"),
            Alumno(11,"Cecilia", 29, "https://cdn-icons-png.flaticon.com/512/2810/2810763.png"),

            )

    }
}