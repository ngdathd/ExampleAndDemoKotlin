package com.ngdathd.exampleanddemokotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

class SummaryFragment : Fragment() {
    private lateinit var tvNumberOfMedal: TextView

    private val mMedalViewModel: MedalViewModel by activityViewModels()
//    private val model: BlankViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvNumberOfMedal = view.findViewById(R.id.tvNumberOfMedal)

        displayMedal()

        mMedalViewModel.numberOfGoldMedal.observe(viewLifecycleOwner, Observer<Int> {i ->
            displayMedal()
        })
        mMedalViewModel.numberOfSilverMedal.observe(
            viewLifecycleOwner,
            Observer<Int> { displayMedal() })
        mMedalViewModel.numberOfBronzeMedal.observe(
            viewLifecycleOwner,
            Observer<Int> { displayMedal() })


//       val nameTextView = view.findViewById<TextView>(R.id.tvNumberOfMedal)
//        model.number.observe(viewLifecycleOwner, Observer {
//            nameTextView.text = it.toString()
//        })
//
//        val button = view.findViewById<TextView>(R.id.buttonHC)
//        button.setOnClickListener {
//            model.setNumber(100)
//        }
    }

    fun displayMedal() {
        val totalMedal: Int =
            mMedalViewModel.numberOfGoldMedal.value!!.plus(mMedalViewModel.numberOfSilverMedal.value!!)
                .plus(mMedalViewModel.numberOfBronzeMedal.value!!)
        tvNumberOfMedal.text = activity?.getString(R.string.number_of_medal_label, totalMedal)
    }
}