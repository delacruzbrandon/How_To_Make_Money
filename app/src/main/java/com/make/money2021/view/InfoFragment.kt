package com.make.money2021.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.make.money2021.R
import com.make.money2021.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

    private lateinit var infoBinding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        infoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        infoBinding.clickHandler = this@InfoFragment


        return infoBinding.root
    }

    fun goBack() {
        val action = InfoFragmentDirections.actionInfoFragmentToHomeFragment()
        NavHostFragment.findNavController(this@InfoFragment).navigate(action)
    }
}