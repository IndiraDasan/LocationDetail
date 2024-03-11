package com.example.locationdetail.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.locationdetail.R

public class MapFragmentDirections private constructor() {
  public companion object {
    public fun actionMapFragment2ToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mapFragment2_to_homeFragment)
  }
}
