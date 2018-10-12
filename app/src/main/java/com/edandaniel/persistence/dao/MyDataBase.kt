package com.edandaniel.persistence.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.edandaniel.persistence.model.Game

@Database(entities = arrayOf(Game::class), version = 1)
abstract class MyDataBase : RoomDatabase() {
    abstract fun gameDAO(): GameDAO
    companion object {
        var INSTANCE: MyDataBase? = null
        fun getDatabase(context: Context): MyDataBase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                        MyDataBase::class.java,
                        "gamesdbs")
                        .build()
            }
            return INSTANCE
        }
    }
}