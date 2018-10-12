package com.edandaniel.persistence.model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.edandaniel.persistence.dao.MyDataBase

class ListGameViewModel(application: Application): AndroidViewModel(application) {
    lateinit var games: LiveData<List<Game>>
    private val bd:MyDataBase = MyDataBase.getDatabase(application.applicationContext)!!
        init{
        carregarDados()
    }

    private fun carregarDados() {
        games = bd.gameDAO().listGames()
    }
}
