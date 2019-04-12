package com.example.cisco.oberdanclass_1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.cisco.oberdanclass_1.extensions.toast

class AccountActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bundle :Bundle? = intent.extras
        var userLogin = bundle!!.getString("user_login")

        val userLoginText = findViewById<TextView>(R.id.userLoginText)
        userLoginText.text = userLogin
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        when(id){
            android.R.id.home -> {finish()
                return true
            }
            R.id.action_search -> {
                toast("Clicou em Search")
                return true
            }
            R.id.action_refresh -> {toast("Clicou em Refresh")
                return true
            }
            R.id.action_settings -> {
                toast("Clicou em Settings")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_account, menu)
        return super.onCreateOptionsMenu(menu)
    }
}