package com.hanifkf12.newjsonapp.presenter

import com.hanifkf12.newjsonapp.model.Covid
import com.hanifkf12.newjsonapp.util.HttpHandler
import com.hanifkf12.newjsonapp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray

class MainPresenter(private val httpHandler: HttpHandler, private val mainView: MainView) {

    fun getData(url: String) = GlobalScope.launch(IO) {
        mainView.showLoading()
        val response = httpHandler.makeServiceCall(url)
        val json = JSONArray(response)
        val data = json.getJSONObject(0)
        val name = data.getString("name")
        val positif = data.getString("positif")
        val sembuh = data.getString("sembuh")
        val meninggal = data.getString("meninggal")
        val covid = Covid(name, positif, sembuh, meninggal)
        withContext(Main) {
            mainView.showData(covid)
            mainView.hideLoading()
        }


    }
}