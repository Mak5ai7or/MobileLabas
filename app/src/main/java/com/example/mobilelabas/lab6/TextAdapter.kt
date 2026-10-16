package com.example.mobilelabas.lab6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilelabas.R

class TextAdapter(private val texts: List<Text>, private val onClick: (Text) -> Unit) : RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(texts[position])
        holder.itemView.setOnClickListener { onClick(texts[position]) }
    }

    override fun getItemCount(): Int = texts.size

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.itemTitle)
        fun bind(text: Text) {
            title.text = text.name
        }
    }
}