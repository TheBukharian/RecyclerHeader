package com.example.recyclerheader.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerheader.R
import kotlinx.android.synthetic.main.item_add_destination.view.*
import kotlinx.android.synthetic.main.red_item.view.*


class DestinationAdapter(var dataList : ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class footerHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        init {
            Log.d("lastindex", "${dataList.lastIndex}")



            itemView.addBtn.setOnClickListener {
                if (dataList.size < 4){
                    itemView.addBtn.visibility = View.VISIBLE
                    dataList.add(0 , "owioeiwoe")
                    notifyItemInserted(0)
                }else{
                    itemView.addBtn.visibility = View.GONE
                    dataList.add(0 , "owioeiwoe")
                    notifyItemInserted(0)
                }


            }
        }


        fun bindFooter(){

        }




    }
    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.delBtn.setOnClickListener {

                if (dataList.size < 4){
                    dataList.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                    notifyItemChanged(dataList.lastIndex)

                }else{
                    dataList.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                    notifyItemChanged(dataList.lastIndex)
                }

            }
        }
    }

    private val TYPE_ITEM : Int = 1
    private val TYPE_FOOTER : Int = 2

    private var onItemClick : View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM) {
            val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_add_destination, parent, false)
            view.setOnClickListener(onItemClick)
            return Holder(view)
        }else  {
            val footerView = LayoutInflater.from(parent.context).inflate(R.layout.red_item, parent, false)
            return footerHolder(footerView)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(isPositionFooter(position)) {
            TYPE_FOOTER
        }else {
            TYPE_ITEM
        }
    }




    override fun getItemCount(): Int {
       return  dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if(isPositionFooter(position)){
            val footerHolder=holder as footerHolder
            if(dataList.lastIndex != 4){

                footerHolder.itemView.addBtn.visibility = View.VISIBLE
            } else{
                footerHolder.itemView.addBtn.visibility = View.GONE
            }

        }

    }






    private fun isPositionFooter(position: Int): Boolean{
        return position == dataList.lastIndex
    }

}




