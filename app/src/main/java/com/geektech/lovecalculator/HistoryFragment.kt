package com.geektech.lovecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    lateinit var binding:FragmentHistoryBinding
    lateinit var adapter: HistoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HistoryAdapter()
        binding.historyRv.adapter = adapter
        adapter.addLoves(App.appDatabase.loveDao().getAllForAlphabet())
        binding.homeBtn.setOnClickListener{
            findNavController().navigate(R.id.firstFragment)
        }
    }
}