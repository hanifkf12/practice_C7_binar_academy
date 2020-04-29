package com.hanifkf12.newmvpapp.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(private val context: Context){
    companion object{
        private const val LOGIN = "LOGIN"
        private const val USERNAME = "USERNAME"
    }
    private val sharedPreferences : SharedPreferences = context.getSharedPreferences("app", Context.MODE_PRIVATE)

    var login : Boolean
        get() {
            return sharedPreferences.getBoolean(LOGIN,false)
        }
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(LOGIN,value)
                apply()
            }
        }

    var username : String?
        get() {
            return sharedPreferences.getString(USERNAME,null)
        }
        set(value) {
            sharedPreferences.edit().apply {
                putString(USERNAME,value)
                apply()
            }
        }
}