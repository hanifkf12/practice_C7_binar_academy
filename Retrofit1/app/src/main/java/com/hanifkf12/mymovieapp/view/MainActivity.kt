package com.hanifkf12.mymovieapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanifkf12.mymovieapp.R
import com.hanifkf12.mymovieapp.adapter.MovieAdapter
import com.hanifkf12.mymovieapp.model.Result
import com.hanifkf12.mymovieapp.presenter.MainPresenter
import com.hanifkf12.mymovieapp.repository.MovieRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    companion object{
        val TAG = MainActivity.javaClass.simpleName
    }
    private lateinit var repository : MovieRepository
    private val listMovie : MutableList<Result> = mutableListOf()
    private lateinit var adapter : MovieAdapter
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MovieAdapter(listMovie)
        adapter.setOnItemClickListener {
            Toast.makeText(this,it.title,Toast.LENGTH_SHORT).show()
        }
        setupRecyclerView()
        repository = MovieRepository()
        presenter = MainPresenter(repository, this)
        presenter.getMovies()
    }

    private fun setupRecyclerView(){
        rv_movies.adapter = adapter
        rv_movies.layoutManager = LinearLayoutManager(this)
        rv_movies.setHasFixedSize(true)
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showData(data: List<Result>) {
        listMovie.clear()
        listMovie.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showError(t: Throwable) {
        Toast.makeText(this,t.message,Toast.LENGTH_SHORT).show()
    }
}
