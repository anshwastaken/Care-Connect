package com.example.careconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.careconnect.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var splashBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed(object : Runnable{
            override fun run() {
                val intent = Intent(this@SplashActivity,ChooseActivity::class.java)
                startActivity(intent)
            }

        },3000)
    }
}