package com.edandaniel.persistence

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.edandaniel.persistence.model.Game

class GameAdapter(var games: List<Game>) :
        RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    override fun getItemCount(): Int {
        return games.size
    }
    fun setList(games: List<Game>) {
        this.games = games
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): GameViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_game, parent, false)
        return GameViewHolder(v)
    }
    override fun onBindViewHolder(holder: GameViewHolder, i: Int)
    {
        val game = games[i]
        holder.tvGame.text = game.name
        holder.tvPlataforma.text = game.platform
    }
    class GameViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvGame: TextView = v.findViewById(R.id.tvGame)
        var tvPlataforma: TextView =
                v.findViewById(R.id.tvPlatform)
    }
}
