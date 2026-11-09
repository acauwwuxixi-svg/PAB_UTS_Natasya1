package com.example.uts_catatanharian.ui.auth

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_catatanharian.R
import com.example.uts_catatanharian.ui.dashboard.DashboardActivity_137
import com.example.uts_catatanharian.utils.SessionManager_137

@SuppressLint("CustomSplashScreen")
class SplashActivity_137 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sessionManager = SessionManager_137(this)

        Handler(Looper.getMainLooper()).postDelayed({
            if (sessionManager.isLoggedIn()) {
                val intent = Intent(this, DashboardActivity_137::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, LoginActivity_137::class.java)
                startActivity(intent)
                finish()
            }
        }, 1500)
    }
}
