package com.example.locationdetail.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.locationdetail.R

public class SigningFragmentDirections private constructor() {
  public companion object {
    public fun actionSigningFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_signingFragment_to_homeFragment)

    public fun actionSigningFragmentToLoginFragment2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_signingFragment_to_loginFragment2)
  }
}
