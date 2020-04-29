package com.hanifkf12.newmvpapp.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hanifkf12.newmvpapp.R
import com.hanifkf12.newmvpapp.db.AppDatabase
import com.hanifkf12.newmvpapp.model.User
import com.hanifkf12.newmvpapp.presenter.RegisterPresenter
import com.hanifkf12.newmvpapp.repository.UserRepository
import com.hanifkf12.newmvpapp.view.login.MainActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val appDatabase = AppDatabase.getDatabase(this)
        val repository = UserRepository(appDatabase.userDao())
        val presenter = RegisterPresenter(repository, this)
        btn_register.setOnClickListener {
            val username = et_username_regist.text.toString()
            val password = et_password_regist.text.toString()
            val user = User(null, username,password)
            if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Fill The Form", Toast.LENGTH_SHORT).show()
            }else{
                presenter.registerUser(user)
            }
        }

    }

    override fun showRegisterResult(status: Boolean) {
        if (status){
            val intent = Intent(this,MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }
            startActivity(intent)
        }
    }

    override fun showMessage(data: String) {
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show()
    }
}
