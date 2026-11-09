package com.example.uts_catatanharian.data.repository

import com.example.uts_catatanharian.data.dao.UserDao_137
import com.example.uts_catatanharian.data.entity.UserEntity_137

class UserRepository_137(private val userDao: UserDao_137) {
    suspend fun registerUser_137(user: UserEntity_137): Long {
        return userDao.registerUser_137(user)
    }

    suspend fun getUserByUsername_137(username: String): UserEntity_137? {
        return userDao.getUserByUsername_137(username)
    }

    suspend fun getUserById_137(userId: Long): UserEntity_137? {
        return userDao.getUserById_137(userId)
    }
}
