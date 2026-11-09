package com.example.uts_catatanharian.ui.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_catatanharian.R
import com.example.uts_catatanharian.data.database.AppDatabase_137
import com.example.uts_catatanharian.data.entity.UserEntity_137
import com.example.uts_catatanharian.data.repository.UserRepository_137
import com.example.uts_catatanharian.utils.HashUtils_137
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity_137 : AppCompatActivity() {

    private lateinit var userRepository: UserRepository_137

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val userDao = AppDatabase_137.getDatabase_137(this).userDao_137()
        userRepository = UserRepository_137(userDao)

        val etUsername = findViewById<TextInputEditText>(R.id.et_reg_username_137)
        val etPassword = findViewById<TextInputEditText>(R.id.et_reg_password_137)
        val etConfirmPassword = findViewById<TextInputEditText>(R.id.et_reg_confirm_password_137)
        val btnRegister = findViewById<MaterialButton>(R.id.btn_register_137)
        val tvToLogin = findViewById<android.widget.TextView>(R.id.tv_to_login_137)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Password dan konfirmasi password tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            CoroutineScope(Dispatchers.IO).launch {
                val existingUser = userRepository.getUserByUsername_137(username)
                if (existingUser != null) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@RegisterActivity_137, "Username sudah digunakan", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    val salt = HashUtils_137.generateSalt()
                    val passwordHash = HashUtils_137.hashPassword(password, salt)
                    val newUser = UserEntity_137(username = username, passwordHash = passwordHash, salt = salt)
                    userRepository.registerUser_137(newUser)

                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@RegisterActivity_137, "Registrasi Berhasil. Silakan Login", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            }
        }

        tvToLogin.setOnClickListener {
            finish()
        }
    }
}
