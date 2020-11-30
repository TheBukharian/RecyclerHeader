package com.example.recyclerheader.Adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerheader.MainActivity
import com.example.recyclerheader.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.red_item.view.*

class RedAdapter(): Item<GroupieViewHolder>() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val desList = arrayListOf<DestinationAdapter>()
        val ob = MainActivity().redAdapter


        viewHolder.itemView.addBtn.setOnClickListener {
            desList.add(0,DestinationAdapter())
                    ob.clear()
                    ob.addAll(desList)
                    ob.add(RedAdapter())
                    ob.notifyDataSetChanged()
            MainActivity().mainRecycler
        }
    }

    override fun getLayout(): Int = R.layout.red_item
}