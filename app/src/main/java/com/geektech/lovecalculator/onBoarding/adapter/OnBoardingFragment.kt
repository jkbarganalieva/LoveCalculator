package com.geektech.lovecalculator.onBoarding.adapter

import OnBoardingAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.Pref
import com.geektech.lovecalculator.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator3
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    lateinit var binding: FragmentOnBoardingBinding
    //private lateinit var adapter: OnBoardingAdapter

    @Inject
    lateinit var preferences: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences = Pref(requireContext())
        val adapter = OnBoardingAdapter {

            preferences.userSeenOnBoard()
            findNavController().navigateUp()

        }

        binding.viewpager.adapter = adapter
        attachIndicator()
    }

    private fun attachIndicator() {
        val indicator: CircleIndicator3 = binding.indicator
        val viewPager = binding.viewpager
        indicator.setViewPager(viewPager)
    }
}