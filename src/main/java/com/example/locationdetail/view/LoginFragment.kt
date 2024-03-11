package com.example.locationdetail.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.locationdetail.Common.AppPreferences
import com.example.locationdetail.R
import com.example.locationdetail.databinding.FragmentLoginBinding
import com.example.locationdetail.model.LocationDetails
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {


    private var _binding: FragmentLoginBinding?= null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        firebaseAuth = FirebaseAuth.getInstance()

        binding.sigUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signingFragment3)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener { signInTask ->
                        if (signInTask.isSuccessful) {
                            firebaseAuth.currentUser?.getIdToken(true)
                                ?.addOnCompleteListener { idTokenTask ->
                                    if (idTokenTask.isSuccessful) {
                                        val idToken = idTokenTask.result?.token
                                        Log.d(TAG, "ID token: $idToken")
                                        AppPreferences.authToken = idToken
                                        AppPreferences.password = pass
                                        // Now you can use the ID token for secure communication
                                        // with your server or other services


                                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment3
                                        )
                                    } else {
                                        // Handle the error obtaining ID token
                                        Log.e(TAG, "Error obtaining ID token", idTokenTask.exception)
                                        Toast.makeText(
                                            requireContext(),
                                            "Error obtaining ID token",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        } else {
                            // Handle the error during sign-in
                            Toast.makeText(requireContext(), signInTask.exception.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
            } else {
                Toast.makeText(requireContext(), "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }

        }


        if(firebaseAuth.currentUser != null){
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment3)

        }
    }


    override fun onPause(){
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }



    override fun onDestroyView(){
        _binding = null
        Log.d(TAG, "onDestroyView: ")
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    companion object{
        const val TAG = "LoginFragment"
    }



}