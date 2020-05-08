package com.hanifkf12.mymovieapp.view

import com.hanifkf12.mymovieapp.model.Result

interface MainView {
    fun showLoading()
    fun showData(data : List<Result>)
    fun hideLoading()
    fun showError(t : Throwable)
}