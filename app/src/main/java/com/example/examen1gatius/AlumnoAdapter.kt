package com.example.examen1gatius

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class AlumnoAdapter(val context: Context): ListAdapter<Alumno, AlumnoAdapter.ViewHolder>(DiffCallBack) {


    lateinit var onItemClickListener: (Alumno) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textViewNombreItem: TextView = view.findViewById(R.id.textViewNombreItem)
        private val textViewEdadItem: TextView = view.findViewById(R.id.textViewEdadItem)
        private val imageViewImagenItem: ImageView = view.findViewById(R.id.imageViewImagenItem)




        fun bind (alumno: Alumno) {
            textViewNombreItem.text = "Nombre: " + alumno.name
            textViewEdadItem.text = "edad: " + alumno.age

            Glide.with(context)
                .load(alumno.url)
                .into(imageViewImagenItem)

            view.setOnClickListener{
                onItemClickListener(alumno)}
        }


    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoAdapter.ViewHolder, position: Int) {
        val alumno = getItem(position)
        holder.bind(alumno)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Alumno>() {
        override fun areItemsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
            return oldItem == newItem
        }
    }
}

