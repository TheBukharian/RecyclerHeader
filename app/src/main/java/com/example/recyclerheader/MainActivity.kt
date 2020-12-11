package com.example.recyclerheader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerheader.Adapters.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val adapter = GroupAdapter<GroupieViewHolder>()
    var touchHelper: ItemTouchHelper? =null
    val  data = arrayListOf<String>()
    val redAdapter = DestinationAdapter(this,data)



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



        data.add("wewewewew")

        mainRecycler.adapter = redAdapter

                 touchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0){
                    override fun onMove(
                        recyclerView: RecyclerView,
                        p1: RecyclerView.ViewHolder,
                        p2: RecyclerView.ViewHolder
                    ): Boolean  {
                        val fromPos = p1.adapterPosition
                        val toPos = p2.adapterPosition
                        Collections.swap(data,fromPos,toPos)
                        redAdapter.notifyItemMoved(fromPos,toPos)

                        CoroutineScope(Dispatchers.Main).launch{
                            coroutine(1000)
                        }



                        return true
                    }

                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) { }
                })
                touchHelper!!.attachToRecyclerView(mainRecycler)

    }

    suspend fun coroutine( millis:Long) {
        delay(millis)


        redAdapter.notifyDataSetChanged()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_items,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.selector){
                redAdapter.changeItemButton()


            Log.i("elrjgerg","ekrgrg")
        }


        return super.onOptionsItemSelected(item)
    }

}

