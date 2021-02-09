package com.example.recyclerheader.Adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerheader.R



class BasicAdapter(private val items: MutableList<String>) : RecyclerView.Adapter<BasicAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(parent)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size


    class VH(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_add_destination, parent, false)) {

        fun bind(name: String) = with(itemView) {}
    }
}

