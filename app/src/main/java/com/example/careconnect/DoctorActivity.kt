package com.example.careconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.careconnect.databinding.ActivityDoctorBinding
import com.google.firebase.auth.FirebaseAuth

class DoctorActivity : AppCompatActivity() {
    lateinit var doctoractivity : ActivityDoctorBinding
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        doctoractivity = ActivityDoctorBinding.inflate(layoutInflater)
        val view = doctoractivity.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        doctoractivity.DoctorLoginButton.setOnClickListener {
            val email = doctoractivity.DoctorEmailInput.text.toString()
            val password = doctoractivity.DoctorPasswordInput.text.toString()

            SigninFirebase(email,password)
        }

        doctoractivity.SignUp.setOnClickListener {
            val intent = Intent(this@DoctorActivity,DoctorSignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun SigninFirebase(email : String,password : String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Toast.makeText(applicationContext,"Hello Doctor",Toast.LENGTH_SHORT).show()
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
            val intent = Intent(this@DoctorActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}