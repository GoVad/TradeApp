package com.example.ourtradeapplication

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class SingleChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_chat)
        findViewById<ImageView>(R.id.back).setOnClickListener{
            onBackPressed()
        }
        val chatRecycler:RecyclerView = findViewById(R.id.chatRecycler)
        val list:ArrayList<Pair<String,Boolean>> = ArrayList()
        val random = Random(System.currentTimeMillis())
        for(i in 0 until 50)
            list.add(Pair("Сообщение $i",random.nextBoolean()))
        chatRecycler.adapter = ChatRecyclerAdapter(list)
        chatRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    class ChatRecyclerAdapter(var messages:ArrayList<Pair<String,Boolean>>) : RecyclerView.Adapter<ChatRecyclerAdapter.ChatMessageHolder>() {
        class ChatMessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun setup(pair: Pair<String, Boolean>) {
                itemView.findViewById<TextView>(R.id.text).text = pair.first
                itemView.findViewById<LinearLayout>(R.id.holder).gravity = if (pair.second) Gravity.RIGHT else Gravity.LEFT
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatMessageHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.chat_message, parent, false)
            return ChatMessageHolder(view)
        }

        override fun onBindViewHolder(holder: ChatMessageHolder, position: Int) {
            holder.setup(messages[position])
        }

        override fun getItemCount(): Int {
            return messages.size
        }

    }
}