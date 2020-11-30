package com.example.recyclerheader.Adapters

import android.content.Context
import android.widget.Button
import com.example.recyclerheader.R

import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.red_item.view.*

class DestinationAdapter(): Item<GroupieViewHolder>() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {


    }
    override fun getLayout(): Int = R.layout.item_add_destination


}