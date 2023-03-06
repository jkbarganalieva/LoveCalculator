package com.geektech.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FragmentFirstBinding
import com.geektech.lovecalculator.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    private val viewModel:LoveViewModel by viewModels()

    @Inject
    lateinit var preferences: Pref
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
            }


    private fun initClicker() {

        with(binding) {
            calculateBtn.setOnClickListener {

              viewModel.getLiveLove(firstEt.text.toString(), secondEt.text.toString())
                  .observe(viewLifecycleOwner
                  ) {
                          loveModel ->
                      Log.e("ololo", "initClicker: $loveModel")
                      findNavController().navigate(R.id.secondFragment)
                  }
            }
        }
    }

    companion object {
        const val MODEL_DATA = "DATA"

    }
}