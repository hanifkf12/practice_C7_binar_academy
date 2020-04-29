package com.hanifkf12.newmvpapp.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hanifkf12.newmvpapp.R
import com.hanifkf12.newmvpapp.db.AppDatabase
import com.hanifkf12.newmvpapp.model.User
import com.hanifkf12.newmvpapp.presenter.LoginPresenter
import com.hanifkf12.newmvpapp.repository.UserRepository
import com.hanifkf12.newmvpapp.utils.PreferenceHelper
import com.hanifkf12.newmvpapp.view.HomeActivity
import com.hanifkf12.newmvpapp.view.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginView {
    private lateinit var preferenceHelper: PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferenceHelper = PreferenceHelper(this)
        val appDatabase = AppDatabase.getDatabase(this)
        val repository = UserRepository(appDatabase.userDao())
        val presenter = LoginPresenter(repository, this)
        if (preferenceHelper.login){
            val intent = Intent(this, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish()
        }
        btn_to_regist.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        btn_login.setOnClickListener {
            val username = et_username_login.text.toString()
            val password = et_passsword_login.text.toString()
            val user = User(null,username,password)
            presenter.loginUser(user)
        }
    }

    override fun showUser(user: User) {
        preferenceHelper.username = user.username
    }

    override fun loginResult(status: Boolean) {
        if(status){
            preferenceHelper.login = status
            val intent = Intent(this, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish()
        }
    }

    override fun showMessage(data: String) {
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show()
    }
}
