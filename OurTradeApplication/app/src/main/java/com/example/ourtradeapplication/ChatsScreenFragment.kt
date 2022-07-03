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
import java.util.*
import kotlin.random.Random

class ChatsScreenFragment : Fragment() {

    companion object {
        fun newInstance() = ChatsScreenFragment()
    }

    private lateinit var viewModel: MainScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_chats_screen, container, false)
        val recycler:RecyclerView = v.findViewById(R.id.chat)
        val rand = Random(System.currentTimeMillis())
        val list = ArrayList<MainScreenViewModel.GoodModel>()
        for (i in 0 until 10)
            list.add(
                MainScreenViewModel.GoodModel(
                    rand.nextInt(400),
                    Date(2022,rand.nextInt(1,7),0,rand.nextInt(0,24),rand.nextInt(0,60)),
                    MainScreenViewModel.names[rand.nextInt(0, MainScreenViewModel.names.size)],
                    MainScreenViewModel.owners[rand.nextInt(0, MainScreenViewModel.owners.size)],
                    0
                ))
        recycler.adapter = ChatAdapter(list)
        recycler.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        return v;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainScreenViewModel::class.java)
    }

    class ChatAdapter(val items:ArrayList<MainScreenViewModel.GoodModel>)
        : RecyclerView.Adapter<ChatAdapter.ChatHolder>() {

        class ChatHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun setup(goodModel: MainScreenViewModel.GoodModel) {
                val formatter = DecimalFormat("00")
                itemView.findViewById<TextView>(R.id.nameChat).text = goodModel.name
                itemView.findViewById<TextView>(R.id.ownerChat).text = goodModel.owner
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.chat_item, parent, false)
            return ChatHolder(view)
        }

        override fun onBindViewHolder(holder: ChatHolder, position: Int) {
            holder.setup(items[position])
        }

        override fun getItemCount(): Int {
            return items.size
        }
    }
}