package com.example.recyclerheader.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerheader.MainActivity
import com.example.recyclerheader.R
import kotlinx.android.synthetic.main.item_add_destination.view.*
import kotlinx.android.synthetic.main.red_item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class DestinationAdapter(val activity: MainActivity, var dataList: ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var isDeleteBoolean=false


    inner class footerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            Log.d("lastindex", "${dataList.lastIndex}")

            itemView.addBtn.setOnClickListener {
                if (dataList.size < 4) {
                    itemView.addBtn.visibility = View.VISIBLE
                } else {
                    itemView.addBtn.visibility = View.GONE
                }

                dataList.add(0, "owioeiwoe")
                notifyItemInserted(dataList.lastIndex)
            }
        }


    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val move = itemView.findViewById<ImageButton>(R.id.moveBtn)

        init {
            itemView.delBtn.setOnClickListener {

                if (dataList.size < 4) {
                    dataList.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)

                } else {
                    dataList.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                }
                CoroutineScope(Dispatchers.Main).launch{
                    coroutine(1000)
                }
            }
        }

        private suspend fun coroutine(millis: Long) {
            delay(millis)
            notifyDataSetChanged()
        }



    }

    private val TYPE_ITEM: Int = 1
    private val TYPE_FOOTER: Int = 2

    private var onItemClick: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_add_destination, parent, false)
            view.setOnClickListener(onItemClick)


            return Holder(view)
        } else {
            val footerView = LayoutInflater.from(parent.context).inflate(R.layout.red_item, parent, false)
            return footerHolder(footerView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isPositionFooter(position)) {
            TYPE_FOOTER
        } else {
            TYPE_ITEM
        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if (getItemViewType(position) == TYPE_ITEM) {


            if(isDeleteBoolean){
                holder.itemView.moveBtn.visibility = View.GONE
                holder.itemView.delBtn.visibility = View.VISIBLE
            } else{
                holder.itemView.moveBtn.visibility = View.VISIBLE
                holder.itemView.delBtn.visibility = View.GONE
            }


            holder.itemView.moveBtn.setOnTouchListener { v, event ->
                if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                    activity.touchHelper?.startDrag(holder)
                }

                false
            }
            holder.itemView.black.text = (position + 1).toString()
        }



        if (isPositionFooter(position)) {
            val footerHolder = holder as footerHolder
            if (dataList.lastIndex != 4) {

                footerHolder.itemView.addBtn.visibility = View.VISIBLE
            } else {
                footerHolder.itemView.addBtn.visibility = View.GONE
            }

        }
    }

    private fun isPositionFooter(position: Int): Boolean {
        return position == dataList.lastIndex
    }


    fun changeItemButton() {
       isDeleteBoolean=!isDeleteBoolean

        notifyDataSetChanged()
    }

}




