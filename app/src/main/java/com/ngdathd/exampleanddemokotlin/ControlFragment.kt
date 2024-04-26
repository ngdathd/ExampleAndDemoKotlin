package com.ngdathd.exampleanddemokotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

class ControlFragment : Fragment(), View.OnClickListener {
    private val mMedalViewModel: MedalViewModel by activityViewModels()
    private lateinit var tvMainGoldNumber: TextView
    private lateinit var tvMainSilverNumber: TextView
    private lateinit var tvMainBronzeNumber: TextView
    private lateinit var btnGoldMinus: Button
    private lateinit var btnGoldPlus: Button
    private lateinit var btnSilverMinus: Button
    private lateinit var btnSilverPlus: Button
    private lateinit var btnBronzeMinus: Button
    private lateinit var btnBronzePlus: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvMainGoldNumber = view.findViewById(R.id.tvMainGoldNumber)
        tvMainSilverNumber = view.findViewById(R.id.tvMainSilverNumber)
        tvMainBronzeNumber = view.findViewById(R.id.tvMainBronzeNumber)

        btnGoldMinus = view.findViewById(R.id.btnGoldMinus)
        btnGoldPlus = view.findViewById(R.id.btnGoldPlus)
        btnSilverMinus = view.findViewById(R.id.btnSilverMinus)
        btnSilverPlus = view.findViewById(R.id.btnSilverPlus)
        btnBronzeMinus = view.findViewById(R.id.btnBronzeMinus)
        btnBronzePlus = view.findViewById(R.id.btnBronzePlus)

        displayMedal()

        btnGoldMinus.setOnClickListener(this)
        btnGoldPlus.setOnClickListener(this)
        btnSilverMinus.setOnClickListener(this)
        btnSilverPlus.setOnClickListener(this)
        btnBronzeMinus.setOnClickListener(this)
        btnBronzePlus.setOnClickListener(this)
    }

    fun displayMedal() {
        tvMainGoldNumber.text = mMedalViewModel.numberOfGoldMedal.value.toString()
        tvMainSilverNumber.text = mMedalViewModel.numberOfSilverMedal.value.toString()
        tvMainBronzeNumber.text = mMedalViewModel.numberOfBronzeMedal.value.toString()
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            btnGoldPlus.id -> {
                mMedalViewModel.numberOfGoldMedal.value = mMedalViewModel.numberOfGoldMedal.value?.plus(1)
                displayMedal()
            }
            btnGoldMinus.id -> {
                mMedalViewModel.numberOfGoldMedal.value = mMedalViewModel.numberOfGoldMedal.value?.minus(1)
                displayMedal()
            }
            btnSilverPlus.id -> {
                mMedalViewModel.numberOfSilverMedal.value = mMedalViewModel.numberOfSilverMedal.value?.plus(1)
                displayMedal()
            }
            btnSilverMinus.id -> {
                mMedalViewModel.numberOfSilverMedal.value = mMedalViewModel.numberOfSilverMedal.value?.minus(1)
                displayMedal()
            }
            btnBronzePlus.id -> {
                mMedalViewModel.numberOfBronzeMedal.value = mMedalViewModel.numberOfBronzeMedal.value?.plus(1)
                displayMedal()
            }
            btnBronzeMinus.id -> {
                mMedalViewModel.numberOfBronzeMedal.value = mMedalViewModel.numberOfBronzeMedal.value?.minus(1)
                displayMedal()
            }
        }
    }
}