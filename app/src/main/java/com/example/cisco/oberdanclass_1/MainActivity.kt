package com.example.cisco.oberdanclass_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cisco.oberdanclass_1.extensions.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var people = mutableListOf(People("Mateus", "12345"))
    var failedLogin = true
    var TAG = "Info"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginInput = findViewById<EditText>(R.id.loginInput)
        val passwordInput  = findViewById<EditText>(R.id.passwordInput)

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val signUpBtn = findViewById<Button>(R.id.signUp)

        loginBtn.setOnClickListener{

            for(person in people){
                if(loginInput.text.toString().toUpperCase() == person.login.toUpperCase() && passwordInput.text.toString().toUpperCase() == person.password.toUpperCase()){
                    toast("Login Ok, " + person.login)

                    loginInput.setText("")
                    passwordInput.setText("")

                    failedLogin = false

                    val intent = Intent(this, AccountActivity::class.java)
                    intent.putExtra("user_login", person.login)
                    startActivity(intent)
                    finish()
                }
            }

            if(failedLogin) {
                loginInput.setText("")
                passwordInput.setText("")
                toast("Login Failed")
            }
            else
                failedLogin = true

        }

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
                toast("Account ${loginInput.text.toString()} created")

                val intent = Intent(this, AccountActivity::class.java)
                intent.putExtra("user_login", loginInput.text.toString())
                startActivity(intent)
                finish()
            }
        }//end SignUp Btn
    }//end OnCreate()
}

data class People(var login:String, var password:String)