package com.hanifkf12.newjsonapp.view

import com.hanifkf12.newjsonapp.model.Covid

interface MainView {
    fun showLoading()
    fun showData(data : Covid)
    fun hideLoading()
}