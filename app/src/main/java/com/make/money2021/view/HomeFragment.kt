package com.make.money2021.view

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.make.money2021.R
import com.make.money2021.adapter.HomeBodyAdapter
import com.make.money2021.databinding.FragmentHomeBinding
import com.make.money2021.service.OnItemClickListener
import com.make.money2021.viewmodel.HomeViewModel
import org.imaginativeworld.whynotimagecarousel.CarouselItem

class HomeFragment : Fragment(), OnItemClickListener {

    private lateinit var homeBinding: FragmentHomeBinding

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val carouselList: List<CarouselItem> = listOf(
            CarouselItem(R.drawable.extra1),
            CarouselItem(R.drawable.extra2),
            CarouselItem(R.drawable.extra3),
        )

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.homeBodyList.observe(viewLifecycleOwner, {
            homeBinding.recyclerViewHomeFragmentBody.adapter = HomeBodyAdapter(it, requireContext(), this)
        })


        homeBinding.imageViewCarouselHomeFragmentFeatured.addData(carouselList)
        homeBinding.clickHandler = this@HomeFragment

        return homeBinding.root
    }


    fun goDetails(position: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(position)
        NavHostFragment.findNavController(this@HomeFragment).navigate(action)
    }

    fun goInfo() {
        val action = HomeFragmentDirections.actionHomeFragmentToInfoFragment()
        NavHostFragment.findNavController(this@HomeFragment).navigate(action)
    }

    override fun onClick(position: Int) {
        goDetails(position)
    }


}