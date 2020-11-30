package com.example.recyclerheader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerheader.Adapters.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.red_item.*


class MainActivity : AppCompatActivity() {

    private val adapter = GroupAdapter<GroupieViewHolder>()

//    val redAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val mainRecycler = findViewById<RecyclerView>(R.id.mainRecycler)





        adapter.add(HeaderView())
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP", "kjekrjekrj")))
        recyclerView.adapter = adapter



       val  data = arrayListOf<String>()

        data.add("wewewewew")


        val redAdapter = DestinationAdapter(data)
        mainRecycler.adapter = redAdapter

    }
}

