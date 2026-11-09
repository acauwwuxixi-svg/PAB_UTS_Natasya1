package com.example.uts_catatanharian.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_catatanharian.R
import com.example.uts_catatanharian.data.database.AppDatabase_137
import com.example.uts_catatanharian.data.repository.UserRepository_137
import com.example.uts_catatanharian.ui.dashboard.DashboardActivity_137
import com.example.uts_catatanharian.utils.HashUtils_137
import com.example.uts_catatanharian.utils.SessionManager_137
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity_137 : AppCompatActivity() {

    private lateinit var userRepository: UserRepository_137
    private lateinit var sessionManager: SessionManager_137

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val userDao = AppDatabase_137.getDatabase_137(this).userDao_137()
        userRepository = UserRepository_137(userDao)
        sessionManager = SessionManager_137(this)

        val etUsername = findViewById<TextInputEditText>(R.id.et_username_137)
        val etPassword = findViewById<TextInputEditText>(R.id.et_password_137)
        val btnLogin = findViewById<MaterialButton>(R.id.btn_login_137)
        val tvToRegister = findViewById<android.widget.TextView>(R.id.tv_to_register_137)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            CoroutineScope(Dispatchers.IO).launch {
                val user = userRepository.getUserByUsername_137(username)
                withContext(Dispatchers.Main) {
                    if (user != null && HashUtils_137.verifyPassword(password, user.salt, user.passwordHash)) {
                        sessionManager.createLoginSession(user.id, user.username)
                        Toast.makeText(this@LoginActivity_137, "Login Berhasil", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@LoginActivity_137, DashboardActivity_137::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity_137, "Username atau password salah", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        tvToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity_137::class.java)
            startActivity(intent)
        }
    }
}
