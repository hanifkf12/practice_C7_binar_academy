package com.hanifkf12.newmvpapp.presenter

import com.hanifkf12.newmvpapp.model.User
import com.hanifkf12.newmvpapp.repository.UserRepository
import com.hanifkf12.newmvpapp.view.login.LoginView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginPresenter(private val repository: UserRepository, private val view : LoginView){
    fun loginUser(user: User) = GlobalScope.launch(Dispatchers.Main) {
        repository.loginUser(user){
            if(it!=null){
                view.loginResult(true)
                view.showMessage("Login Success")
                view.showUser(it)
            }else{
                view.loginResult(false)
                view.showMessage("Login Failed")
            }
        }
    }
}