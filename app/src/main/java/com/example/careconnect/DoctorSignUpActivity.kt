package com.example.careconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.careconnect.databinding.ActivityDoctorSignUpBinding
import com.google.firebase.auth.FirebaseAuth

class DoctorSignUpActivity : AppCompatActivity() {
    lateinit var doctorSignUpBinding: ActivityDoctorSignUpBinding
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        doctorSignUpBinding = ActivityDoctorSignUpBinding.inflate(layoutInflater)
        val view = doctorSignUpBinding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        doctorSignUpBinding.SignUpButton.setOnClickListener {
            val email = doctorSignUpBinding.DoctorSignupEmailInput.text.toString()
            val password = doctorSignUpBinding.DoctorSignupPasswordInput.text.toString()

            SignUpDoctorFirebase(email,password)
        }
    }
    fun SignUpDoctorFirebase(email:String,password : String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Toast.makeText(applicationContext,"Welcome Doctor",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@DoctorSignUpActivity,DoctorActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(applicationContext,task.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        }
    }
}