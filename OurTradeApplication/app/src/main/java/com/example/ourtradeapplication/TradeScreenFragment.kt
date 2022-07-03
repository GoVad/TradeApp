package com.example.ourtradeapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ourtradeapplication.MainScreenViewModel.Companion.months
import java.text.DecimalFormat
import java.util.*
import kotlin.random.Random

class TradeScreenFragment : Fragment() {

    companion object {
        fun newInstance() = TradeScreenFragment()
    }

    private lateinit var viewModel: MainScreenViewModel
    private lateinit var recycler:RecyclerView;



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val returnView = inflater.inflate(R.layout.fragment_trade_screen, container, false)
        recycler = returnView.findViewById(R.id.goods)
        val rand = Random(System.currentTimeMillis())
        val list = ArrayList<MainScreenViewModel.GoodModel>()
        for (i in 0 until 500)
            list.add(
                MainScreenViewModel.GoodModel(
                rand.nextInt(400),
                Date(2022,rand.nextInt(1,7),0,rand.nextInt(0,24),rand.nextInt(0,60)),
                MainScreenViewModel.names[rand.nextInt(0, MainScreenViewModel.names.size)],
                MainScreenViewModel.owners[rand.nextInt(0, MainScreenViewModel.owners.size)],
            0
            ))
        recycler.adapter = GoodsAdapter(list)
        recycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        return returnView;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainScreenViewModel::class.java]
        requireView().findViewById<ImageView>(R.id.maps).setOnClickListener{
            val mapIntent = Intent(Intent.ACTION_VIEW)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}

class GoodsAdapter(val items:ArrayList<MainScreenViewModel.GoodModel>)
    : RecyclerView.Adapter<GoodsAdapter.GoodsHolder>() {

    class GoodsHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setup(goodModel: MainScreenViewModel.GoodModel) {
            val formatter = DecimalFormat("00")
            itemView.findViewById<ImageView>(R.id.likeBtn).setOnClickListener{
                it.foreground.setTint(Color.RED)
            }
            itemView.findViewById<TextView>(R.id.name).text = goodModel.name
            itemView.findViewById<TextView>(R.id.owner).text = goodModel.owner
            itemView.findViewById<TextView>(R.id.cost).text = "${goodModel.cost}${if(position%20>10)"$" else " BYN"}"
            itemView.findViewById<TextView>(R.id.date).text =
                "${goodModel.time.day} " +
                "${months[goodModel.time.month]} " +
                "${formatter.format(goodModel.time.hours)}:" +
                "${formatter.format(goodModel.time.minutes)}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.goods_item, parent, false)
        view.setOnClickListener{
            val createIntent = Intent(parent.context, SingleGoodActivity::class.java)
            ContextCompat.startActivity(parent.context, createIntent, null)
        }
        return GoodsHolder(view)
    }

    override fun onBindViewHolder(holder: GoodsHolder, position: Int) {
        holder.setup(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
