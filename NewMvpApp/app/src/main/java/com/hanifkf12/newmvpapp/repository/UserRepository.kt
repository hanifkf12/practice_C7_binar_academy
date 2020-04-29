package com.hanifkf12.newmvpapp.repository

import com.hanifkf12.newmvpapp.db.UserDao
import com.hanifkf12.newmvpapp.model.User

class UserRepository (private val userDao: UserDao){

    suspend fun registerUser(user: User){
        userDao.register(user)
    }

    suspend fun loginUser(user : User, onLogin : (User?)->Unit){
        val result = userDao.login(user.username, user.password)
        onLogin(result)
    }
}