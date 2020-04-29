package com.hanifkf12.mvp1app.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hanifkf12.mvp1app.R
import com.hanifkf12.mvp1app.model.Task
import com.hanifkf12.mvp1app.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), HomeView {
    private lateinit var presenter: HomePresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = HomePresenter(this)
        presenter.loadData()
    }

    override fun showData(data: Task) {
        tv_data.text = data.title
    }

}
