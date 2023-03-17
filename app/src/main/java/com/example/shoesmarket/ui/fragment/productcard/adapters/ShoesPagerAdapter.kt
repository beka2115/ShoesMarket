package com.example.shoesmarket.ui.fragment.productcard.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoesmarket.databinding.ItemShoesPagerBinding

class ShoesPagerAdapter : RecyclerView.Adapter<ShoesPagerAdapter.ShoesPagerViewHolder>() {

    private val listShoes = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesPagerViewHolder {
        return ShoesPagerViewHolder(
            ItemShoesPagerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return listShoes.size
    }

    override fun onBindViewHolder(holder: ShoesPagerViewHolder, position: Int) {
        holder.bind(listShoes[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addShoes(list: String) {
        listShoes.clear()
        listShoes.add(list)
        notifyDataSetChanged()
    }

    inner class ShoesPagerViewHolder(private val binding: ItemShoesPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(imgShoes: String) {
            if (imgShoes!=null){
                Glide.with(binding.imgPagerShoes).load(imgShoes).into(binding.imgPagerShoes)
            }else{
                Glide.with(binding.imgPagerShoes).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz9RJkNDp7C_87ZaWPnkr1ZbJPjdDodDUJWw&usqp=CAU").into(binding.imgPagerShoes)
            }

        }
    }
}