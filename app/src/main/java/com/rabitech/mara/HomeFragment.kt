package com.rabitech.mara


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.rabitech.mara.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_login.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        binding.homeCard1.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_harvestRequest)
        )
        binding.homeCard2.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_bankAccountFragment)
        )
        binding.homeCard3.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_paymentStatus)
        )
        binding.homeCard4.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_profile_to_login)
        )
        return binding.root
    }


}
