package com.example.locationdetail.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.locationdetail.R

public class PolylineFragmentDirections private constructor() {
  public companion object {
    public fun actionPolylineFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_polylineFragment_to_homeFragment)
  }
}
