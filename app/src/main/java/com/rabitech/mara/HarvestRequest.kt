package com.rabitech.mara


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.rabitech.mara.databinding.FragmentHarvestRequestBinding
import com.rabitech.mara.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_harvest_request.*
import kotlinx.android.synthetic.main.fragment_harvest_request.view.*

class HarvestRequest : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_harvest_request, container, false)
        val binding: FragmentHarvestRequestBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_harvest_request, container, false
        )
        binding.btnSubmit.setOnClickListener(

            Navigation.createNavigateOnClickListener(R.id.action_harvestRequest_to_harvest)
        )
        return binding.root
    }

}
