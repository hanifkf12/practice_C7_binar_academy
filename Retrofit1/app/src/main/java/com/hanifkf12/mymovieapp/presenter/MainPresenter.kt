package com.hanifkf12.mymovieapp.presenter

import android.util.Log
import android.view.View
import com.hanifkf12.mymovieapp.repository.MovieRepository
import com.hanifkf12.mymovieapp.view.MainActivity
import com.hanifkf12.mymovieapp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainPresenter(private val repository: MovieRepository, private val view: MainView) {
    fun getMovies() {
        view.showLoading()
        repository.getMovies({
            Log.d(MainActivity.TAG, it.results?.size.toString())
            view.showData(it.results!!)
            view.hideLoading()
        }, {
            Log.e(MainActivity.TAG, it.message!!)
            view.showError(it)
            view.hideLoading()
        })
    }
}