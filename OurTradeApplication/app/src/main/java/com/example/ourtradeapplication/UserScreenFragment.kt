package com.example.ourtradeapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.DecimalFormat
import java.util.ArrayList

class UserScreenFragment : Fragment() {

    companion object {
        fun newInstance() = UserScreenFragment()
    }

    private lateinit var viewModel: MainScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_user_screen, container, false)
        val recycler:RecyclerView = v.findViewById(R.id.userInfoScroller)
        recycler.adapter = UserInfoAdapter()
        recycler.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        return v;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainScreenViewModel::class.java)
    }

    class UserInfoAdapter()
        : RecyclerView.Adapter<UserInfoAdapter.InfoHolder>() {

        class InfoHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_info, parent, false)
            return InfoHolder(view)
        }

        override fun onBindViewHolder(holder: InfoHolder, position: Int) {
        }

        override fun getItemCount(): Int {
            return 1
        }
    }
}