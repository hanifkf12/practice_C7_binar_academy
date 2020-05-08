package com.hanifkf12.newjsonapp.util

import android.util.Log
import java.io.*
import java.lang.StringBuilder
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class HttpHandler {
    companion object{
        val TAG = HttpHandler.javaClass.simpleName
    }

    fun makeServiceCall(reqUrl : String) : String?{
        var response : String? = null
        try {
            val url = URL(reqUrl)
            val connection = url.openConnection() as HttpsURLConnection
            connection.readTimeout = 15000
            connection.requestMethod = "GET"
            val inputStream = BufferedInputStream(connection.inputStream)
            response = convertStreamToString(inputStream)
            Log.d(TAG, response)
        }catch (ex : IOException){
            ex.printStackTrace()
        }
        return response
    }

    private fun convertStreamToString(inputStream: InputStream) : String{
        val reader = BufferedReader(InputStreamReader(inputStream))
        val builder = StringBuilder()
        var line = reader.readLine()
        try {
            while (line !=null){
                builder.append(line + "\n")
                line = reader.readLine()
            }
        }catch (ex : IOException){
            ex.printStackTrace()
        }finally {
            try {
                inputStream.close()
            }catch (e : IOException){
                e.printStackTrace()
            }
        }
        return  builder.toString()
    }
}