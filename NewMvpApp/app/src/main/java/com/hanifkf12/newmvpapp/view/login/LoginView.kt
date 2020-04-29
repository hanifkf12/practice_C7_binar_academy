package com.hanifkf12.newmvpapp.view.login

import com.hanifkf12.newmvpapp.model.User

interface LoginView {
    fun showUser(user: User)
    fun loginResult(status : Boolean)
    fun showMessage(data : String)
}