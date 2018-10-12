package com.edandaniel.persistence.model

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.AsyncTask
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import com.edandaniel.persistence.R
import com.edandaniel.persistence.dao.MyDataBase
import kotlinx.android.synthetic.main.new_game_dialog.*

class NewGameDialog : DialogFragment() {
    private lateinit var builder: AlertDialog.Builder
    private lateinit var etGame: EditText
    private lateinit var spPlatform: Spinner
    override fun onCreateDialog(savedInstanceState: Bundle?):
            Dialog {
        builder = AlertDialog.Builder(activity)
        val v = activity.layoutInflater.inflate(R.layout.new_game_dialog, null)
        etGame = v.findViewById(R.id.etGame)
        spPlatform = v.findViewById(R.id.spPlatform)
        builder.setView(v)
        builder.setTitle("New Game")
        builder.setPositiveButton("Add") { _, _ ->
            val db =
                    MyDataBase.getDatabase(activity.applicationContext)
            val game = Game()//Game(etGame.text.toString(),etPlatform.text.toString())
            game.name = etGame.text.toString()
            //game.platform = etPlatform.text.toString()
            game.platform = spPlatform.selectedItem.toString()

            if (game.name != "")
                InsertAsyncTask(db!!).execute(game)
        }
        builder.setNegativeButton("Cancel", null)
        return builder.create()
    }
    private inner class InsertAsyncTask internal
    constructor(appDatabase: MyDataBase) : AsyncTask<Game, Void,
            String>() {
        private val db: MyDataBase = appDatabase
        override fun doInBackground(vararg params: Game): String
        {
            db.gameDAO().insert(params[0])
            return ""
        }
    }
}