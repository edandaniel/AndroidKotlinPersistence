package com.edandaniel.persistence.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

//@Entity(tableName = "GameTable") if you want a different name
@Entity
class Game{

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var name: String? = null
    var platform: String? = null

    fun constructor() {}

    fun constructor(name: String, genre: String) {
        this.name = name
        this.platform = genre
    }

    fun constructor(id: Int, nome: String, genre: String) {
        this.id = id
        this.name = nome
        this.platform = genre
    }
}