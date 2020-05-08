package com.hanifkf12.retrofitcrud.presenter

import android.util.Log
import com.hanifkf12.retrofitcrud.model.request.PersonBody
import com.hanifkf12.retrofitcrud.repository.PersonRepository
import com.hanifkf12.retrofitcrud.ui.MainActivity
import com.hanifkf12.retrofitcrud.ui.MainView
import kotlinx.android.synthetic.main.activity_main.*

class PersonPresenter(private val repository: PersonRepository, private val view : MainView){
    fun createPerson(personBody: PersonBody){
        view.showLoading()
        repository.createPerson(personBody,{
            Log.d(MainActivity.TAG, it.result?.firstName!!)
            view.showData("Create Person Success ${it.result.firstName}")
            view.hideLoading()
        },{
            Log.e(MainActivity.TAG, it.message!!)
            view.hideLoading()
        })
    }

    fun updatePerson(id : String, personBody: PersonBody){
        view.showLoading()
        repository.updatePerson("28",personBody,{
            Log.d(MainActivity.TAG, it.result)
            view.showData(it.result!!)
            view.hideLoading()
        },{
            Log.e(MainActivity.TAG, it.message!!)
            view.hideLoading()
        })
    }

    fun getPersonById(id: String){
        view.showLoading()
        repository.getPersonById(id,{
           view.showData("${it.result!!.firstName} ${it.result.lastName}")
            view.hideLoading()
        },{
            Log.e(MainActivity.TAG, it.message!!)
            view.hideLoading()
        })
    }
}