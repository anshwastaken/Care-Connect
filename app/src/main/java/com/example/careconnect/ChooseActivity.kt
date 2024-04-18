package com.example.careconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.careconnect.databinding.ActivityChooseBinding

class ChooseActivity : AppCompatActivity() {
    lateinit var chooseBinding: ActivityChooseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        chooseBinding = ActivityChooseBinding.inflate(layoutInflater)
        val view = chooseBinding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        chooseBinding.DoctorCard.setOnClickListener {
            val intent = Intent(this@ChooseActivity,DoctorActivity::class.java)
            startActivity(intent)
            finish()
        }

        chooseBinding.PatientCard.setOnClickListener {
            val intent = Intent(this@ChooseActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}