package com.example.locationdetail.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.locationdetail.R
import com.example.locationdetail.databinding.FragmentPolylineBinding
import com.example.locationdetail.model.PolyLineDetail
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions


class PolylineFragment : Fragment(),OnMapReadyCallback{

    private var _binding: FragmentPolylineBinding? = null
    private val binding get() = _binding!!
    private var mMap: GoogleMap? = null
    lateinit var visitorlist: MutableList<PolyLineDetail>
//    // below are the latitude and longitude of 4 different locations.
//    var TamWorth = LatLng(-31.083332, 150.916672)
//    var NewCastle = LatLng(-32.916668, 151.750000)
//    var Brisbane = LatLng(-27.470125, 153.021072)

    private val navArgs : PolylineFragmentArgs by navArgs()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPolylineBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        visitorlist = mutableListOf()
//
//        visitorlist.add(PolyLineDetail(-31.083332,150.916672))
//        visitorlist.add(PolyLineDetail(-32.916668,151.750000))
//        visitorlist.add(PolyLineDetail(-27.470125,153.021072))



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        // Find the SupportMapFragment within the childFragmentManager
        val mapFragment = childFragmentManager.findFragmentById(com.example.locationdetail.R.id.polyline_map_view) as SupportMapFragment
        if (mapFragment != null){
            // Handle the case when the fragment is found
            Log.d(TAG, "onViewCreated:Handle the case when the fragment is found ")
            mapFragment.getMapAsync(this)
        } else {
            // Handle the case when the fragment is not found
            Log.d(TAG, "onViewCreated:Handle the case when the fragment is not found ")
        }
       Log.d(TAG, "latitude: ${navArgs.mapDetail?.polyLineDetail?.forEach { it.latitude.toString()}}")

    }




    companion object{
        const val TAG = "PolylineFragment"
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0

        val polylineOptions = PolylineOptions()

        navArgs.mapDetail?.polyLineDetail?.forEach {
            val latLng = LatLng(it.latitude, it.longitude)
            polylineOptions.add(latLng)

        }



        // Customize polyline appearance (optional)
        polylineOptions.width(5f)
        polylineOptions.color(Color.RED)
        polylineOptions.geodesic(true)

        // Add the polyline to the map
         mMap!!.addPolyline(polylineOptions)

        // Set camera position to the first point in the polyline
        if (navArgs.mapDetail?.polyLineDetail?.isNotEmpty() == true) {
            val firstPoint = LatLng(navArgs.mapDetail?.polyLineDetail!![0].latitude , navArgs.mapDetail?.polyLineDetail!![0].longitude)
            p0.moveCamera(CameraUpdateFactory.newLatLngZoom(firstPoint, 13f))
        }else{
            Log.d(TAG, "onMapReady: isempty")
        }
    }

//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//        // inside on map ready method
//        // we will be displaying polygon on Google Maps.
//        // on below line we will be adding polyline on Google Maps.
//        mMap!!.addPolyline(
//            PolylineOptions().add(Brisbane, Brisbane, Brisbane)
//                .width // below line is use to specify the width of poly line.
//                    (5f) // below line is use to add color to our poly line.
//                .color(Color.RED) // below line is to make our poly line geodesic.
//                .geodesic(true)
//        )
//        // on below line we will be starting the drawing of polyline.
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Brisbane, 13f))
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}