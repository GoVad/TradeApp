package com.example.ourtradeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CreateGoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_good)
        findViewById<ImageView>(R.id.back).setOnClickListener{
            onBackPressed()
        }
        findViewById<ImageView>(R.id.done).setOnClickListener{
            onBackPressed()
        }
        val recycler = findViewById<RecyclerView>(R.id.addedPhotos)
        recycler.adapter = AddingPhotoAdapter()
        recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    class AddingPhotoAdapter() : RecyclerView.Adapter<AddingPhotoAdapter.PhotoHolder>() {
        class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.photo_item, parent, false)
            return PhotoHolder(view)
        }

        override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
            if(position!=0)
                holder.itemView.findViewById<ImageView>(R.id.photo).visibility = View.GONE
        }

        override fun getItemCount(): Int {
            return 9;
        }
    }
}