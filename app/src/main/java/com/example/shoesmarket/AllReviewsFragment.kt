package com.example.shoesmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoesmarket.ui.adapters.AllReviewAdapter
import com.example.shoesmarket.databinding.FragmentReviewsBinding
import com.example.shoesmarket.ui.ProductCardViewModel


class AllReviewsFragment : Fragment() {

    private lateinit var binding: FragmentReviewsBinding
    private lateinit var viewModel: ProductCardViewModel
    private val adapter = AllReviewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReviewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()
        initListener()
    }

    private fun initListener() {
        viewModel.getReview().observe(viewLifecycleOwner) {
            adapter.addAllReviews(it)
        }
    }

    private fun initViews() {
        with(binding) {
            recyclerReview.layoutManager =
                LinearLayoutManager(context)
            recyclerReview.adapter = adapter
        }

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[ProductCardViewModel::class.java]
    }

}