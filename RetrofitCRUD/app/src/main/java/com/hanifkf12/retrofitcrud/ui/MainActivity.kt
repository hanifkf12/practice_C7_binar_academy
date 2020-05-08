package com.hanifkf12.retrofitcrud.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.hanifkf12.retrofitcrud.R
import com.hanifkf12.retrofitcrud.model.request.PersonBody
import com.hanifkf12.retrofitcrud.presenter.PersonPresenter
import com.hanifkf12.retrofitcrud.repository.PersonRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    companion object{
        val TAG = MainActivity.javaClass.simpleName
    }
    private lateinit var repository: PersonRepository
    private lateinit var presenter: PersonPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repository = PersonRepository()
        presenter = PersonPresenter(repository, this)
        btn_create.setOnClickListener {
            val personBody = PersonBody("TestHANif","Coba")
            presenter.createPerson(personBody)
        }

        btn_update.setOnClickListener {
            val personBody = PersonBody("Update 1","Test HAnif")
            presenter.updatePerson("28", personBody)
        }
        btn_load.setOnClickListener {
            presenter.getPersonById("28")
        }

    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showData(data: String) {
        tv_name.text = data
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE

    }
}
