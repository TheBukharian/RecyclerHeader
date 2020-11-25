package com.example.recyclerheader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        val adapter = GroupAdapter<GroupieViewHolder>()
        adapter.add(HeaderView())
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))
        adapter.add(ItemView(ins = RoadInfo("OOOOOOOPPOPOP","kjekrjekrj")))

        recyclerView.adapter = adapter



    }
}