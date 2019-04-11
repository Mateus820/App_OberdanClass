package com.example.cisco.oberdanclass_1.extensions
import android.app.Activity
import android.widget.Toast

fun Activity.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, length).show()
