package com.example.recyclerheader

import android.widget.TextView
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item


class ItemView(val ins:RoadInfo):Item<GroupieViewHolder>(){

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        val title = viewHolder.itemView.findViewById<TextView>(R.id.titleText)
        val text = viewHolder.itemView.findViewById<TextView>(R.id.TexT)

            title.text = ins.title_text
            text.text = ins.sub_text
    }

    override fun getLayout(): Int { return R.layout.item }
}
class HeaderView():Item<GroupieViewHolder>(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) { }
    override fun getLayout(): Int = R.layout.header_item

}
    class RoadInfo(val title_text:String, val sub_text:String) {
    constructor():this("","")
}
