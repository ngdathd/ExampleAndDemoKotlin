package com.ngdathd.exampleanddemokotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

class DetailFragment: Fragment() {
    private lateinit var tvDetailGoldNumber: TextView
    private lateinit var tvDetailSilverNumber: TextView
    private lateinit var tvDetailBronzeNumber: TextView

    private val mMedalViewModel: MedalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvDetailGoldNumber = view.findViewById(R.id.tvDetailGoldNumber)
        tvDetailSilverNumber = view.findViewById(R.id.tvDetailSilverNumber)
        tvDetailBronzeNumber = view.findViewById(R.id.tvDetailBronzeNumber)

        displayMedal()

        mMedalViewModel.numberOfGoldMedal.observe(viewLifecycleOwner, Observer<Int> { displayMedal() })
        mMedalViewModel.numberOfSilverMedal.observe(viewLifecycleOwner, Observer<Int> { displayMedal() })
        mMedalViewModel.numberOfBronzeMedal.observe(viewLifecycleOwner, Observer<Int> { displayMedal() })
    }
    fun displayMedal() {
        tvDetailGoldNumber.text = activity?.getString(R.string.number_of_gold_label, mMedalViewModel.numberOfGoldMedal.value)
        tvDetailSilverNumber.text = activity?.getString(R.string.number_of_silver_label, mMedalViewModel.numberOfSilverMedal.value)
        tvDetailBronzeNumber.text = activity?.getString(R.string.number_of_bronze_label, mMedalViewModel.numberOfBronzeMedal.value)
    }
}