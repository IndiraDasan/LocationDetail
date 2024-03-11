package com.example.locationdetail.view

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.locationdetail.model.LocationDetails
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class MapFragmentArgs(
  public val locationdetail: LocationDetails,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(LocationDetails::class.java)) {
      result.set("locationdetail", this.locationdetail as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(LocationDetails::class.java)) {
      result.set("locationdetail", this.locationdetail as Serializable)
    } else {
      throw UnsupportedOperationException(LocationDetails::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): MapFragmentArgs {
      bundle.setClassLoader(MapFragmentArgs::class.java.classLoader)
      val __locationdetail : LocationDetails?
      if (bundle.containsKey("locationdetail")) {
        if (Parcelable::class.java.isAssignableFrom(LocationDetails::class.java) ||
            Serializable::class.java.isAssignableFrom(LocationDetails::class.java)) {
          __locationdetail = bundle.get("locationdetail") as LocationDetails?
        } else {
          throw UnsupportedOperationException(LocationDetails::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__locationdetail == null) {
          throw IllegalArgumentException("Argument \"locationdetail\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"locationdetail\" is missing and does not have an android:defaultValue")
      }
      return MapFragmentArgs(__locationdetail)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): MapFragmentArgs {
      val __locationdetail : LocationDetails?
      if (savedStateHandle.contains("locationdetail")) {
        if (Parcelable::class.java.isAssignableFrom(LocationDetails::class.java) ||
            Serializable::class.java.isAssignableFrom(LocationDetails::class.java)) {
          __locationdetail = savedStateHandle.get<LocationDetails?>("locationdetail")
        } else {
          throw UnsupportedOperationException(LocationDetails::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__locationdetail == null) {
          throw IllegalArgumentException("Argument \"locationdetail\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"locationdetail\" is missing and does not have an android:defaultValue")
      }
      return MapFragmentArgs(__locationdetail)
    }
  }
}
