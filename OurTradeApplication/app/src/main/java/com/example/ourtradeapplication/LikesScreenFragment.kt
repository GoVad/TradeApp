package com.example.ourtradeapplication

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class LikesScreenFragment : Fragment() {

    companion object {
        fun newInstance() = LikesScreenFragment()
    }

    private lateinit var viewModel: MainScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_likes_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val goodsLikes = requireView().findViewById<TextView>(R.id.goodsLikes)
        val searchLikes = requireView().findViewById<TextView>(R.id.searchLikes)
        val sellerLikes = requireView().findViewById<TextView>(R.id.sellerLikes)

        goodsLikes.setOnClickListener{
            goodsLikes.setBackgroundColor(Color.GREEN)
            searchLikes.setBackgroundColor(Color.WHITE)
            sellerLikes.setBackgroundColor(Color.WHITE)
        }

        searchLikes.setOnClickListener{
            searchLikes.setBackgroundColor(Color.GREEN)
            goodsLikes.setBackgroundColor(Color.WHITE)
            sellerLikes.setBackgroundColor(Color.WHITE)
        }

        sellerLikes.setOnClickListener{
            sellerLikes.setBackgroundColor(Color.GREEN)
            goodsLikes.setBackgroundColor(Color.WHITE)
            searchLikes.setBackgroundColor(Color.WHITE)
        }

        viewModel = ViewModelProvider(this).get(MainScreenViewModel::class.java)
    }
}