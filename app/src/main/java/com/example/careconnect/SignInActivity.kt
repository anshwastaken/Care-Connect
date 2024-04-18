package com.example.careconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.careconnect.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    lateinit var SigninActivity : ActivitySignInBinding
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        SigninActivity = ActivitySignInBinding.inflate(layoutInflater)
        val view = SigninActivity.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        SigninActivity.SignUpButton.setOnClickListener {
            val email = SigninActivity.SignupEmailInput.text.toString()
            val password = SigninActivity.SignupPasswordInput.text.toString()

            SignUpFirebase(email,password)
        }
    }

    fun SignUpFirebase(email : String,password : String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Toast.makeText(applicationContext,"Signed up",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SignInActivity,SigninActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext,task.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
            }

        }
    }
}