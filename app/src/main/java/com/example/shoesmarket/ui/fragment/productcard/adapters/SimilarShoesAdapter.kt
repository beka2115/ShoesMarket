package com.example.shoesmarket.ui.fragment.productcard.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoesmarket.databinding.ItemSimilarBinding

class SimilarShoesAdapter : RecyclerView.Adapter<SimilarShoesAdapter.SimilarShoesViewHolder>() {

    private var listSimilar = arrayListOf<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarShoesViewHolder {
        return SimilarShoesViewHolder(
            ItemSimilarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listSimilar.size
    }

    override fun onBindViewHolder(holder: SimilarShoesViewHolder, position: Int) {
       holder.bind(listSimilar[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addSimilarShoes(list:ArrayList<String>){
        listSimilar.clear()
        listSimilar.addAll(list)
        notifyDataSetChanged()
    }

    inner class SimilarShoesViewHolder(private val binding: ItemSimilarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imgSimilar: String) {
            if (imgSimilar!=null){
                Glide.with(binding.imgSimilar).load(imgSimilar).into(binding.imgSimilar)
            }else{
                Glide.with(binding.imgSimilar).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz9RJkNDp7C_87ZaWPnkr1ZbJPjdDodDUJWw&usqp=CAU").into(binding.imgSimilar)
            }
        }
    }

}