package com.hanifkf12.jsonapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity(), MainView {
    companion object{
        const val myJson= "{\n" +
                "\t\"nama\" : \"Hanif\",\n" +
                "\t\"alamat\" : \"Jogja\",\n" +
                "\t\"umur\" : 22,\n" +
                "\t\"hobi\" : [\n" +
                "\t\t{\n" +
                "\t\t\t\"nama\" : \"Main Game\",\n" +
                "\t\t\t\"intensitas\": \"Setiap Hari\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"nama\" : \"Tidur\",\n" +
                "\t\t\t\"intensitas\": \"Setiap Hari\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"nama\" : \"Makan\",\n" +
                "\t\t\t\"intensitas\": \"Setiap Hari\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}"

        val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var httpHandler: HttpHandler
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        httpHandler = HttpHandler()
        presenter = MainPresenter(httpHandler, this)
        presenter.getData("https://api.kawalcorona.com/indonesia/")
//        Log.d(TAG, myJson)
//        val obj = JSONObject(loadJsonFromAsset())
//        val nama = obj.getString("nama")
//        tv_nama.text = nama
//        val alamat = obj.getString("alamat")
//        tv_alamat.text = alamat
//        val umur = obj.getInt("umur")
//        tv_umur.text = umur.toString()
//        val hobi : JSONArray = obj.getJSONArray("hobi")
//        tv_hobi.text = ""
//        for(i in 0 until hobi.length()){
//            val data = hobi.getJSONObject(i)
//            val namaHobi = data.getString("nama")
//            tv_hobi.append("$namaHobi\n")
//        }

    }

    private fun loadJsonFromAsset() : String?{
        var json : String? = null
        val charset : Charset = Charsets.UTF_8
        try {
            val file = assets.open("biodata.json")
            val size = file.available()
            val buffer = ByteArray(size)
            file.read(buffer)
            file.close()
            json = String(buffer,charset)
        }catch (ex : IOException){
            ex.printStackTrace()
            return null
        }
        return json
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showData(data: Data) {
        tv_nama.text = data.name
        tv_alamat.text = data.positif
        tv_umur.text = data.sembuh
        tv_hobi.text = data.meninggal
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }
}
