package com.hanifkf12.jsonapplication

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray

class MainPresenter(private val httpHandler: HttpHandler, private val view: MainView) {
    companion object {
        val TAG = MainPresenter.javaClass.simpleName
    }

    fun getData(url: String) = GlobalScope.launch(Dispatchers.IO) {
        view.showLoading()
        val json = httpHandler.makeServiceCall(url)
        Log.d(TAG, json)
        val dataArray = JSONArray(json)
        val data = dataArray.getJSONObject(0)
        val nama = data.getString("name")
        val positif = data.getString("positif")
        val sembuh = data.getString("sembuh")
        val meninggal = data.getString("meninggal")
        val datanya = Data(nama, positif, sembuh, meninggal)
        withContext(Main) {
            view.showData(datanya)
            view.hideLoading()
        }
    }
}