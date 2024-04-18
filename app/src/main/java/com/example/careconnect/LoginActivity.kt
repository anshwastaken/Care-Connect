package com.example.careconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.careconnect.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var loginBinding: ActivityLoginBinding
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = loginBinding.root
        super.onCreate(savedInstanceState)
        setContentView(view)



        loginBinding.LoginButton.setOnClickListener {
            val email = loginBinding.EmailInput.text.toString()
            val password = loginBinding.PasswordInput.text.toString()

            SignInFirebase(email,password)
        }

        loginBinding.ForgotPassword.setOnClickListener {

        }

        loginBinding.SignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity,SignInActivity::class.java)
            startActivity(intent)
        }

        loginBinding.googleSignIn.setOnClickListener {

        }


    }

    fun SignInFirebase(email : String,password: String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {task ->
            if (task.isSuccessful){
                Toast.makeText(applicationContext,"Signed In",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity,HomePageActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(applicationContext,task.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if(user!=null){
            Toast.makeText(applicationContext,"Successfully Signed In",Toast.LENGTH_SHORT).show()
            val intent = Intent(this@LoginActivity,HomePageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}