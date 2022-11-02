package com.siksin.helloandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.data_list_item.*

class ExtensionDataAdapter(
    val items: ArrayList<String>
): RecyclerView.Adapter<ExtensionViewHolder>( ) {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtensionViewHolder {
        return ExtensionViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.data_list_item,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ExtensionViewHolder, position: Int) {
        holder.tv_data_type.text = items[position]
    }
}