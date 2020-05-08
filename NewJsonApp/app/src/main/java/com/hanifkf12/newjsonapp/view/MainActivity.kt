package com.hanifkf12.newjsonapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hanifkf12.newjsonapp.R
import com.hanifkf12.newjsonapp.model.Covid
import com.hanifkf12.newjsonapp.presenter.MainPresenter
import com.hanifkf12.newjsonapp.util.HttpHandler
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
        const val myJson="{\n" +
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
        val TAG = MainActivity.javaClass.simpleName
    }
    private lateinit var httpHandler: HttpHandler
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        httpHandler = HttpHandler()
        presenter = MainPresenter(httpHandler, this)
        presenter.getData("https://api.kawalcorona.com/indonesia/")
//        val jsonObject = JSONObject(loadJsonFromAsset())
//        val nama = jsonObject.getString("nama")
//        tv_nama.text = nama
//        val alamat = jsonObject.getString("alamat")
//        tv_alamat.text = alamat
//        val umur = jsonObject.getInt("umur")
//        tv_umur.text = umur.toString()
//        val hobi = jsonObject.getJSONArray("hobi")
//        tv_hobi.text = ""
//        for(i in 0 until hobi.length()){
//            val data = hobi.getJSONObject(i)
//            val namaHobi = data.getString("nama")
//            val intensitas = data.getString("intensitas")
//            tv_hobi.append("$namaHobi - $intensitas \n")
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
        }catch (e : IOException){
            e.printStackTrace()
            return null
        }

        return json
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showData(data: Covid) {
        tv_nama.text = data.name
        tv_alamat.text = "${data.positif} Positif"
        tv_umur.text = "${data.sembuh} Sembuh"
        tv_hobi.text = "${data.meninggal} Meninggal"
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }
}
