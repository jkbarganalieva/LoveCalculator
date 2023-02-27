package com.geektech.lovecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FragmentSecondBinding

@Suppress("DEPRECATION")
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable(FirstFragment.MODEL_DATA) as LoveModel
        with(binding) {
            firstTv.text = data.firstName
            secondTv.text = data.secondName
            percentageTv.text = data.percentage + "%"
            messageTv.text = data.result
            againBtn.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}