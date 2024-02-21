package com.cursoandroid.viewmodelapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cursoandroid.viewmodelapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        //Creacion de viewmodel
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        // Vinculacion del viewmodel
        binding.firstViewModel = viewModel
        binding.lifecycleOwner = this

        // click listeners
        binding.firstFragmentBtHello.setOnClickListener {
            viewModel.hello(binding.firstFragmentEtName.text.toString())
        }

        binding.firstFragmentBtGoodbye.setOnClickListener {
            viewModel.goodbye(binding.firstFragmentEtName.text.toString())
        }

        binding.firstFragmentBtEnd.setOnClickListener {

        }

        return binding.root
    }



}