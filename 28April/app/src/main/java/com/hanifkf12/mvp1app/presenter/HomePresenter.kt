package com.hanifkf12.mvp1app.presenter

import com.hanifkf12.mvp1app.model.Task
import com.hanifkf12.mvp1app.view.home.HomeView

class HomePresenter(private val view : HomeView) {
    fun loadData(){
        val task = Task("Ngoding Ngabuburit")
        view.showData(task)
    }
}