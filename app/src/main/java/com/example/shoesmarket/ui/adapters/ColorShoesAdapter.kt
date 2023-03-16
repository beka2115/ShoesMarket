package com.example.shoesmarket.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoesmarket.data.remote.model.ShoesColorModel
import com.example.shoesmarket.databinding.ItemColorBinding


class ColorShoesAdapter(
) : RecyclerView.Adapter<ColorShoesAdapter.ColorShoesViewHolder>() {

    private var listImgColor = arrayListOf<ShoesColorModel>()
    private var isChoose: Boolean? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorShoesViewHolder {
        return ColorShoesViewHolder(
            ItemColorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listImgColor.size
    }

    override fun onBindViewHolder(holder: ColorShoesViewHolder, position: Int) {
        holder.bind(listImgColor[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addColorList(imgColor: ArrayList<ShoesColorModel>) {
        listImgColor.clear()
        listImgColor.addAll(imgColor)
        notifyDataSetChanged()
    }

    inner class ColorShoesViewHolder(private val binding: ItemColorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(img: ShoesColorModel) {
            itemView.setOnClickListener {

                if (!img.isChoose) {
                    img.isChoose = checkClick(img.isChoose)
                    setVisibility(img.isChoose)
                } else if (img.isChoose) {
                    img.isChoose = checkClick(img.isChoose)
                    setVisibility(img.isChoose)
                }

            }
            if (isChoose == false) {
                img.isChoose = false
                binding.imgColorStroke.isVisible = false
            }

            Glide.with(binding.imgColor).load(img.shoesColorImg).into(binding.imgColor)
        }

        private fun checkClick(isItClicked: Boolean): Boolean {
            var answer = false
            if (!isItClicked) {
                answer = true
            }
            if (isItClicked) {
                answer = false
            }
            return answer
        }

        private fun setVisibility(answer: Boolean) {
            if (!answer) {
                binding.imgColorStroke.isVisible = false
            }
            if (answer) {
                binding.imgColorStroke.isVisible = true
            }
        }
    }

}