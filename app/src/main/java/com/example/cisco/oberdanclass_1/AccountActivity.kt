package com.example.cisco.oberdanclass_1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AccountActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val bundle :Bundle? = intent.extras
        var userLogin = bundle!!.getString("user_login")

        var returnBtn = findViewById<Button>(R.id.returnBtn)

        val userLoginText = findViewById<TextView>(R.id.userLoginText)
        userLoginText.text = userLogin

        returnBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this, "Thank you, " + userLoginText.text, Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }

}