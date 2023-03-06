package com.geektech.lovecalculator

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
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
    lateinit var preferences: SharedPreferences

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
        if (!isUserSeen()) {
            findNavController().navigate(R.id.onBoardingFragment)
        }
    }

    private fun isUserSeen(): Boolean {
        return preferences.getBoolean(SEEN_KEY, false)
    }

    private fun initClicker() {
        with(binding) {
            calculateBtn.setOnClickListener {
              viewModel.getLiveLove(firstEt.text.toString(), secondEt.text.toString())
                  .observe(viewLifecycleOwner
                  ) { loveModel ->
                      Log.e("ololo", "initClicker: $loveModel")
                  }
            }
        }
    }

    companion object {
        const val MODEL_DATA = "DATA"
        const val SEEN_KEY = "userSeen"
    }
}