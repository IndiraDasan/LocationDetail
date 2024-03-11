package com.example.locationdetail.view

import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.findNavController
import com.example.locationdetail.Common.AppPreferences
import com.example.locationdetail.R
import com.example.locationdetail.databinding.FragmentSigninBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.jar.Manifest

class SigningFragment : Fragment() {


     private var _binding: FragmentSigninBinding? = null
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
        _binding = FragmentSigninBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        firebaseAuth = FirebaseAuth.getInstance()

        binding.sigIn.setOnClickListener {
            findNavController().navigate(R.id.action_signingFragment_to_loginFragment2)
        }
        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener { createUserTask ->
                            if (createUserTask.isSuccessful) {
                                // The user was created successfully, now get the ID token
                                val user = createUserTask.result?.user
                                user?.getIdToken(true)
                                    ?.addOnCompleteListener { idTokenTask ->
                                        if (idTokenTask.isSuccessful) {
                                            val idToken = idTokenTask.result?.token
                                            Log.d(TAG, "ID token for new user: $idToken")
                                            Log.d(LoginFragment.TAG, "ID token: $idToken")
                                            AppPreferences.authToken = idToken
                                            AppPreferences.password = pass
                                            // Proceed with your logic, e.g., navigate to HomeFragment
                                            findNavController().navigate(R.id.action_signingFragment_to_homeFragment)
                                        } else {
                                            // Handle the error obtaining ID token
                                            Log.e(TAG, "Error obtaining ID token for new user", idTokenTask.exception)
                                            Toast.makeText(
                                                requireContext(),
                                                "Error obtaining ID token for new user",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    }
                            } else {
                                // Handle the error creating the user
                                Toast.makeText(requireContext(), createUserTask.exception?.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(requireContext(), "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
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

    override fun onDestroy() {
        super.onDestroy()

    }



    companion object{
        const val TAG = "SigningFragment"
    }




}