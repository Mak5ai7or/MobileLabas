package com.example.mobilelabas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LabsAdapter(
    private val labs: List<LabItem>,
    private val onClick: (LabItem) -> Unit
    ) : RecyclerView.Adapter<LabsAdapter.LabViewHolder>() {

    class LabViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.button_for_lab)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_for_lab_menu, parent, false)
        return LabViewHolder(view)
    }

    override fun onBindViewHolder(holder: LabViewHolder, position: Int) {
        val lab = labs[position]
        holder.button.text = lab.name
        holder.button.setOnClickListener { onClick(lab) }
    }

    override fun getItemCount(): Int = labs.size
}