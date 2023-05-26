package com.example.examen1gatius

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var textViewName: TextView
    private lateinit var textViewAge: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewName = findViewById(R.id.textViewNameDetalle)
        textViewAge = findViewById(R.id.textViewEdadDetalle)
        imageView = findViewById(R.id.imageViewDetalle)

        val bundle = intent.extras
        val nombre = bundle?.getString("name", "")
        val edad = bundle?.getInt("edad", 0)
        val url = bundle?.getString("url") ?: ""

        textViewName.text = "Nombre: " +  nombre
        textViewAge.text = "Edad: " + edad.toString()
        Glide.with(applicationContext)
            .load(url)
            .into(imageView)
    }
}