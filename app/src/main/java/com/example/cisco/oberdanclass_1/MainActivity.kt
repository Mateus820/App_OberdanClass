package com.example.cisco.oberdanclass_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var people = mutableListOf(People("Mateus", "12345"))


        val loginInput = findViewById<EditText>(R.id.loginInput)
        val passwordInput  = findViewById<EditText>(R.id.passwordInput)

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val signUpBtn = findViewById<Button>(R.id.signUp)

        var failedLogin = true

        loginBtn.setOnClickListener{

            for(person in people){
                if(loginInput.text.toString().toUpperCase() == person.login.toUpperCase() && passwordInput.text.toString().toUpperCase() == person.password.toUpperCase()){
                    Toast.makeText(this, "Login Ok, " + person.login, Toast.LENGTH_SHORT).show()

                    loginInput.setText("")
                    passwordInput.setText("")

                    failedLogin = false

                    val intent = Intent(this, AccountActivity::class.java)

                    intent.putExtra("user_login", person.login)

                    startActivity(intent)
                }
            }

            if(failedLogin) {
                loginInput.setText("")
                passwordInput.setText("")
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
            else
                failedLogin = true


        }//end loginBtn.Click()

        signUpBtn.setOnClickListener {

            var accountExist = false

            for(person in people){

                Log.d("List", "Name: ${person.login}, Password: ${person.password}")

                if(person.login == loginInput.text.toString()){
                    accountExist = true
                    Log.d("Aviso", accountExist.toString())
                }
            }

            if(loginInput.text.toString() == "" || passwordInput.text.toString() == ""){
                accountExist = true
            }

            if(!accountExist){
                people.add(People(loginInput.text.toString(), passwordInput.text.toString()))
                Toast.makeText(this, "Account ${loginInput.text.toString()} created", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, AccountActivity::class.java)

                intent.putExtra("user_login", loginInput.text.toString())

                startActivity(intent)
            }
        }

    }//end OnCreate()
}