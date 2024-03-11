package com.example.locationdetail.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.locationdetail.R
import com.example.locationdetail.databinding.FragmentHomeBinding
import com.example.locationdetail.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

   private lateinit var gMap: GoogleMap

    private var _binding: FragmentMapBinding?= null
    private val binding get() = _binding!!

    private val navArgs: MapFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMapBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Find the SupportMapFragment within the childFragmentManager
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_view) as SupportMapFragment
        if (mapFragment != null) {
            // Handle the case when the fragment is found
            Log.d(TAG, "onViewCreated:Handle the case when the fragment is found ")
            mapFragment.getMapAsync(this)
        } else {
            // Handle the case when the fragment is not found
            Log.d(TAG, "onViewCreated:Handle the case when the fragment is not found ")

        }
        Log.d(TAG, "onMapReady: ${navArgs.locationdetail.latitude}")

    }



    override fun onMapReady(p0: GoogleMap) {

        gMap = p0
        // Set the latitude and longitude coordinates

        val lat = 55.6761
        val lat1 = 12.5683
//        val sydney = LatLng(navArgs.locationdetail.latitude.toDouble(), 151.211)



        val location = LatLng(navArgs.locationdetail.latitude.toDouble(), navArgs.locationdetail.longitude.toDouble())
        //val location = LatLng(lat1,lat)
        // Add a marker at the specified coordinates and move the camera
        p0.addMarker(MarkerOptions().position(location).title("Mayiladuthurai"))
        p0.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12f)) // You can adjust the zoom level

    }

    companion object{
        const val TAG = "MapFragment"
    }
}

