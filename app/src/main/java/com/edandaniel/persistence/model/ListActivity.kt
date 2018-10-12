package com.edandaniel.persistence.model

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.edandaniel.persistence.GameAdapter
import com.edandaniel.persistence.R
import kotlinx.android.synthetic.main.activity_list_games.*
import kotlinx.android.synthetic.main.content_list_games.*

class ListActivity : AppCompatActivity() {
    private var adapter: GameAdapter? = null
    private var games: List<Game> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_games)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            val dialog = NewGameDialog()
            dialog.show(fragmentManager, "CreateGame")
        }
        mostrarDados();
        rvGames.layoutManager = LinearLayoutManager(this)
        adapter = GameAdapter(games!!)
        rvGames.adapter = adapter
    }
    private fun mostrarDados() {
        ViewModelProviders.of(this)
                .get(ListGameViewModel::class.java)
                .games
                .observe(this, Observer<List<Game>> { games ->
                    adapter?.setList(games!!)
                    rvGames.adapter.notifyDataSetChanged()
                })
    }

}
