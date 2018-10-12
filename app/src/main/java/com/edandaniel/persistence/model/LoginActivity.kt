package com.edandaniel.persistence.model

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.edandaniel.persistence.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("myapp",
                Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("KEEP_CONNECTED", false)){
            startActivity(Intent(this, ListActivity::class.java))
            finish()
        }

        btSignIn.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.putBoolean("KEEP_CONNECTED",cbKeep.isChecked)
            editor.putString("USER",etUser.text.toString())
            editor.apply()
            startActivity(Intent(this, ListActivity::class.java))
            finish()
        }
    }
}
