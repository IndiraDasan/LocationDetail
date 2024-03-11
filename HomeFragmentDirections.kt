package com.example.locationdetail.view

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.locationdetail.R
import com.example.locationdetail.model.LocationDetails
import com.example.locationdetail.model.MapDetail
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToMapFragment2(
    public val locationdetail: LocationDetails,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_mapFragment2

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(LocationDetails::class.java)) {
          result.putParcelable("locationdetail", this.locationdetail as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(LocationDetails::class.java)) {
          result.putSerializable("locationdetail", this.locationdetail as Serializable)
        } else {
          throw UnsupportedOperationException(LocationDetails::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  private data class ActionHomeFragmentToPolylineFragment(
    public val mapDetail: MapDetail?,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_polylineFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(MapDetail::class.java)) {
          result.putParcelable("mapDetail", this.mapDetail as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(MapDetail::class.java)) {
          result.putSerializable("mapDetail", this.mapDetail as Serializable?)
        } else {
          throw UnsupportedOperationException(MapDetail::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToMapFragment2(locationdetail: LocationDetails): NavDirections =
        ActionHomeFragmentToMapFragment2(locationdetail)

    public fun actionHomeFragmentToPolylineFragment(mapDetail: MapDetail?): NavDirections =
        ActionHomeFragmentToPolylineFragment(mapDetail)

    public fun actionHomeFragmentToLoginFragment2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_loginFragment2)
  }
}
