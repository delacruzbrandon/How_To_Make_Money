package com.make.money2021.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.make.money2021.R
import com.make.money2021.databinding.FragmentDetailsBinding
import com.make.money2021.viewmodel.DetailsViewModel
import com.make.money2021.viewmodel.DetailsViewModelFactory
import com.make.money2021.viewmodel.HomeViewModel

class DetailsFragment : Fragment() {

    private lateinit var detailsBinding: FragmentDetailsBinding

    private lateinit var detailsViewModelFactory: DetailsViewModelFactory
    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        detailsViewModelFactory = DetailsViewModelFactory(DetailsFragmentArgs.fromBundle(requireArguments()).position)
        detailsViewModel = ViewModelProvider(this, detailsViewModelFactory)[DetailsViewModel::class.java]

        detailsBinding.clickHandler = this@DetailsFragment
        detailsBinding.detailsViewModel = detailsViewModel
        detailsBinding.lifecycleOwner = viewLifecycleOwner

        return detailsBinding.root
    }

    fun goBack() {
        val action = DetailsFragmentDirections.actionDetailsFragmentToHomeFragment()
        NavHostFragment.findNavController(this@DetailsFragment).navigate(action)
    }
}