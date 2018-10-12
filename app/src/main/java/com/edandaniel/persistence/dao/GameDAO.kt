package com.edandaniel.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.edandaniel.persistence.model.Game

@Dao
interface GameDAO {
    @Insert
    fun insert(game: Game)
    @Query("SELECT * FROM Game")
    fun listGames(): LiveData<List<Game>>
    @Query("SELECT * FROM Game WHERE id = :id")
    fun findBy(id: Int): Game
    @Update
    fun update(game: Game)
    @Delete
    fun delete(game: Game)
}
