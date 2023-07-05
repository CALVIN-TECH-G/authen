package com.authen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       auth = Firebase.auth

        val signUpBtn = findViewById<Button>(  R.id.btnsignup  )

        signUpBtn.setOnClickListener {
            val email = findViewById<EditText>(R.id.editText)
            val password = findViewById<EditText>(R.id.passwordtxt)

            val emailString = email.text.toString().trim()
            val passwordString = password.text.toString().trim()
            auth.createUserWithEmailAndPassword(emailString,passwordString).addOnCompleteListener {
                if (it.isSuccessful){
                    val intent = Intent(this,contentscreen::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"signup sucessful", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        }
    }