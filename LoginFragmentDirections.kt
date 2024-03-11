package com.example.locationdetail.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.locationdetail.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToHomeFragment3(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_homeFragment3)

    public fun actionLoginFragmentToSigningFragment3(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_signingFragment3)
  }
}
