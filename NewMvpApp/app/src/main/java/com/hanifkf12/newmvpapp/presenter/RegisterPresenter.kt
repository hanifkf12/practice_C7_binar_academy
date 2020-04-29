package com.hanifkf12.newmvpapp.presenter

import com.hanifkf12.newmvpapp.model.User
import com.hanifkf12.newmvpapp.repository.UserRepository
import com.hanifkf12.newmvpapp.view.register.RegisterView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterPresenter(private val repository: UserRepository, private val view: RegisterView) {

    fun registerUser(user: User) = GlobalScope.launch(Dispatchers.Main) {
        repository.registerUser(user)
        view.showRegisterResult(true)
        view.showMessage("Register Success")
    }

}