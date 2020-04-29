package com.hanifkf12.newmvpapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hanifkf12.newmvpapp.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun register(user: User)

    @Query("SELECT * FROM user_table WHERE username = :username AND password = :password")
    suspend fun login(username : String?, password : String?) : User
}