package com.example.uts_catatanharian.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.uts_catatanharian.data.entity.UserEntity_137

@Dao
interface UserDao_137 {
    @Insert
    suspend fun registerUser_137(user: UserEntity_137): Long

    @Query("SELECT * FROM users_137 WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername_137(username: String): UserEntity_137?

    @Query("SELECT * FROM users_137 WHERE id = :userId LIMIT 1")
    suspend fun getUserById_137(userId: Long): UserEntity_137?
}
