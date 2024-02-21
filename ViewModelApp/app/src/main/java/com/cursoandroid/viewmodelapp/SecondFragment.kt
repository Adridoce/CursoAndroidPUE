package com.cursoandroid.viewmodelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cursoandroid.viewmodelapp.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: SecondViewModel
    private lateinit var viewModelFactory: SecondViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        viewModelFactory =
            SecondViewModelFactory(SecondFragmentArgs.fromBundle(requireArguments()).clicks)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)

        viewModel.clicks.observe(
            viewLifecycleOwner,
            Observer { clickNumber ->
                binding.secondFragmentTvClicks.text = clickNumber.toString()
            })

        binding.secondFragmentBtClick.setOnClickListener { viewModel.addClick() }
        binding.secondFragmentBtBack.setOnClickListener { goFirstFragment() }

        return binding.root
    }

    private fun goFirstFragment() {
        findNavController().navigate(
            SecondFragmentDirections.actionSecondFragmentToFirstFragment()
        )
    }

}