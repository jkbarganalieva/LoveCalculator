package com.geektech.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
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
                LoveService().api.calculatePercentage(
                    firstName = firstEt.text.toString(),
                    secondName = secondEt.text.toString()
                ).enqueue(object : Callback<LoveModel> {

                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            Log.e("ololo", "onResponse: ${response.body()}")
                            findNavController().navigate(
                                R.id.secondFragment,
                                bundleOf(MODEL_DATA to response.body())
                            )
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure: ${t.message}")
                    }
                })
            }
        }
    }

    companion object {
        const val MODEL_DATA = "DATA"
    }
}