package com.example.careconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import com.example.careconnect.databinding.ActivityHomePageBinding
import com.google.firebase.auth.FirebaseAuth

class HomePageActivity : AppCompatActivity() {
    lateinit var homePageBinding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        homePageBinding = ActivityHomePageBinding.inflate(layoutInflater)
        val view = homePageBinding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

//        val activity : HomePageActivity = HomePageActivity()
//
//        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
//            override fun handleOnBackPressed() {
//                val dialogBox = AlertDialog.Builder(this@HomePageActivity)
//                dialogBox.setTitle("Do u want to exit this app?")
//                dialogBox.setCancelable(false)
//                dialogBox.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
//
//                })
//
//            }
//
//        })

        homePageBinding.AppointmentCard.setOnClickListener {

        }

        homePageBinding.VideoCallCard.setOnClickListener {

        }

        homePageBinding.MedicineCard.setOnClickListener {

        }

        homePageBinding.MoreButton.setOnClickListener {

        }

    }
}

