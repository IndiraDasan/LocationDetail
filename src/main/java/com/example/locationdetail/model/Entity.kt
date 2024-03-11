package com.example.locationdetail.model

import android.os.Parcelable
import androidx.annotation.Keep
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class PolyLineDetail(
    var latitude: Double,
    var longitude: Double
):Parcelable


@Keep
@Parcelize
data class LocationDetails(
     var latitude: String,
     var longitude: String,
     var country: String?,
     var Locality: String,
     var Address: String?,
     var email:String?,
     var password:String?,
) : Parcelable


@Keep
@Parcelize
data class MapDetail(
    var polyLineDetail: List<PolyLineDetail> = emptyList()
) : Parcelable

@RealmClass
open class MapDb:RealmObject(){
@PrimaryKey
    var id:Long = 0
    var email:String? = ""
    var password:String? = ""
    var locationData:RealmList<LocationData>? = null
}

//@RealmClass
//open class LocationData(
//    var latitude: String,
//    var longitude:String,
//    var country:String,
//    var Locality:String,
//    var Address:String
//) :RealmObject() {
//
//}

@RealmClass
  open class LocationData(
    var latitude: String = "",
    var longitude:String = "",
    var country:String= "",
    var Locality:String= "",
    var Address:String= ""
) : RealmObject() {
    // No additional code needed here as all fields have default values
}
