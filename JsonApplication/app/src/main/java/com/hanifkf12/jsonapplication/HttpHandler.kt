package com.hanifkf12.jsonapplication

import android.util.Log
import java.io.*
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.ProtocolException
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class HttpHandler {
    companion object{
        val TAG = HttpHandler.javaClass.simpleName
    }

    fun makeServiceCall(reqUrl : String) : String?{
        var response : String? = null

        try{
            val url = URL(reqUrl)
            val conn = url.openConnection() as HttpsURLConnection
            conn.requestMethod = "GET"
            val inputStream = BufferedInputStream(conn.inputStream)
            response = convertStreamToString(inputStream)
        }catch (e : MalformedURLException){
            Log.e(TAG, "MalformedURLException ${e.message}")
        }catch (e : ProtocolException){
            Log.e(TAG, "ProtocolException ${e.message}")
        }catch (e : IOException){
            Log.e(TAG, "IOException ${e.message}")
        }catch (e : Exception){
            Log.e(TAG, "Exception ${e.message}")
        }

        return response
    }

    private fun convertStreamToString(inputStream: InputStream) : String{
        val reader = BufferedReader(InputStreamReader(inputStream))
        val builder = StringBuilder()

        var line = reader.readLine()
        try {
            while (line != null) {
                builder.append(line!! + "\n")
                line = reader.readLine()       // <-- Add this
            }
        }catch (e : IOException){
            e.printStackTrace()
        }finally {
            try {
                inputStream.close()
            }catch (e : IOException){
                e.printStackTrace()
            }
        }

        return builder.toString()
    }
}