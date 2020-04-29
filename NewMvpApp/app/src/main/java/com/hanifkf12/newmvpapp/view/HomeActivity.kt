package com.hanifkf12.newmvpapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hanifkf12.newmvpapp.R
import com.hanifkf12.newmvpapp.utils.PreferenceHelper
import com.hanifkf12.newmvpapp.view.login.MainActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val preferenceHelper = PreferenceHelper(this)
        tv_username.text = preferenceHelper.username
        btn_logout.setOnClickListener {
            preferenceHelper.login = false
            preferenceHelper.username = ""
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
