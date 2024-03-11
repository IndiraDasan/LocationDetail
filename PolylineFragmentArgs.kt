package com.example.locationdetail.view

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.locationdetail.model.MapDetail
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class PolylineFragmentArgs(
  public val mapDetail: MapDetail?,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(MapDetail::class.java)) {
      result.set("mapDetail", this.mapDetail as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(MapDetail::class.java)) {
      result.set("mapDetail", this.mapDetail as Serializable?)
    } else {
      throw UnsupportedOperationException(MapDetail::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): PolylineFragmentArgs {
      bundle.setClassLoader(PolylineFragmentArgs::class.java.classLoader)
      val __mapDetail : MapDetail?
      if (bundle.containsKey("mapDetail")) {
        if (Parcelable::class.java.isAssignableFrom(MapDetail::class.java) ||
            Serializable::class.java.isAssignableFrom(MapDetail::class.java)) {
          __mapDetail = bundle.get("mapDetail") as MapDetail?
        } else {
          throw UnsupportedOperationException(MapDetail::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"mapDetail\" is missing and does not have an android:defaultValue")
      }
      return PolylineFragmentArgs(__mapDetail)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): PolylineFragmentArgs {
      val __mapDetail : MapDetail?
      if (savedStateHandle.contains("mapDetail")) {
        if (Parcelable::class.java.isAssignableFrom(MapDetail::class.java) ||
            Serializable::class.java.isAssignableFrom(MapDetail::class.java)) {
          __mapDetail = savedStateHandle.get<MapDetail?>("mapDetail")
        } else {
          throw UnsupportedOperationException(MapDetail::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"mapDetail\" is missing and does not have an android:defaultValue")
      }
      return PolylineFragmentArgs(__mapDetail)
    }
  }
}
