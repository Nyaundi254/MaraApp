package com.rabitech.mara


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NavigationRes
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.rabitech.mara.databinding.FragmentRegisterBinding

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var mAuth: FirebaseAuth

    private var userEmail = ""
    private var userPassword = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_register, container, false)

        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_register, container, false
        )
        mAuth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {
            signUp()
        }
        binding.textSignin.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_login)
        )
        return binding.root
    }

    private fun signUp() {
        mAuth.createUserWithEmailAndPassword(userEmail, userPassword)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_profile_to_homeFragment)
                }
            }.addOnFailureListener {

                //            Toast.makeText(" Failed to register the user  "+userEmail +it.message, Toast.LENGTH_SHORT).show
            }
    }


}
