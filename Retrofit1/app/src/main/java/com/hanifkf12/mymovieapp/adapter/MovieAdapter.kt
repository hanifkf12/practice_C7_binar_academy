package com.hanifkf12.mymovieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hanifkf12.mymovieapp.R
import com.hanifkf12.mymovieapp.model.Result
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter (private val data : List<Result>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    private lateinit var listener : (Result) -> Unit

    fun setOnItemClickListener(listener : (Result)-> Unit){
        this.listener = listener
    }
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: Result){
            itemView.tv_title.text = result.title
            itemView.tv_year.text = result.releaseDate
            itemView.tv_ratting.text = result.voteAverage.toString()
            Glide.with(itemView).load("https://image.tmdb.org/t/p/w500${result.posterPath}").into(itemView.iv_poster)
            itemView.setOnClickListener {
                listener(result)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

}