package com.example.locationdetail.view

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.locationdetail.Common.AppPreferences
import com.example.locationdetail.R
import com.example.locationdetail.adapter.LocationDetailAdapter
import com.example.locationdetail.databinding.FragmentHomeBinding
import com.example.locationdetail.model.LocationData
import com.example.locationdetail.model.LocationDetails
import com.example.locationdetail.model.MapDb
import com.example.locationdetail.model.MapDetail
import com.example.locationdetail.model.PolyLineDetail
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.firebase.auth.FirebaseAuth
import io.realm.Realm
import io.realm.RealmList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Suppress("DEPRECATION")
class HomeFragment : androidx.fragment.app.Fragment(),LocationDetailAdapter.clickListener {

    private lateinit var mFusedLocationClient: FusedLocationProviderClient

    private val permissionId = 2

    private var realm: Realm? = null

//    private val navArgs : HomeFragmentArgs by navArgs()

    private var locationDetailAdapter: LocationDetailAdapter? = null

    private var dataModals: List<MapDb>? = null






    private val handler = Handler(Looper.getMainLooper())
    private var interval = 5000L // 5 seconds

    var locationList: ArrayList<LocationData>? = null
    private var mapDetails: MutableList<PolyLineDetail>? = null


    private var _binding: FragmentHomeBinding?= null
    private val binding get() = _binding!!
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }


    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        realm = Realm.getDefaultInstance()

        locationList = ArrayList()
        mapDetails = mutableListOf()
        firebaseAuth = FirebaseAuth.getInstance()
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        requestNewLocationData()

        Log.d(TAG, "authtoken: ${AppPreferences.authToken}")

        binding.playBackbtn.setOnClickListener {
            if (locationList!!.isNotEmpty()){
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPolylineFragment(
                    MapDetail(mapDetails!!)
                ))
            }else{
                Toast.makeText(requireContext(), "no location Detail", Toast.LENGTH_SHORT).show()
            }

        }



        if(firebaseAuth.currentUser == null){

            findNavController().navigate(R.id.action_homeFragment_to_loginFragment2)
        }



    }

    private fun startContinuousTask(){
        // Post the initial task to start the continuous execution
        handler.post(continuousTask)
    }


    private val continuousTask = object : Runnable {
        override fun run() {
            // Perform your task here
            // For example, update location, fetch data, etc.
            //requestNewLocationData()

            // Schedule the next execution after the specified interval
            handler.postDelayed(this, interval)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        requireActivity().menuInflater.inflate(R.menu.logoutbutton,menu)
        return super.onCreateOptionsMenu(menu,inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.settings ->{ firebaseAuth.signOut()
        findNavController().navigate(R.id.action_homeFragment_to_loginFragment2)}
        }
        return super.onOptionsItemSelected(item)
    }


    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                // Initializing LocationRequest
                // object with appropriate methods
                val mLocationRequest = LocationRequest()
                mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                mLocationRequest.setInterval(10000)
                mLocationRequest.setFastestInterval(1000)

                // setting LocationRequest
                // on FusedLocationClient
                mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext());
                mFusedLocationClient.requestLocationUpdates(
                    mLocationRequest,
                    mLocationCallback,
                    Looper.myLooper()
                );
            }else{
                Toast.makeText(requireContext(), "Please turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        }else {
            requestPermissions()
        }
    }

    private val mLocationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val mLastLocation = locationResult.lastLocation ?: return
            val geocoder = Geocoder(requireContext(), java.util.Locale.getDefault())
            try {
                val list: List<Address>? = geocoder.getFromLocation(
                    mLastLocation.latitude,
                    mLastLocation.longitude,
                    1
                )

                if (list != null && list.isNotEmpty()){
                    val address = list[0]
                    val country = address.countryName
                    val locality = address.locality
                    val addressLine = address.getAddressLine(0)
                    // Now you can use the country, locality, and addressLine as needed
                    // For example, you can update TextViews or store them in your data structure
                    val detail = LocationData(latitude = mLastLocation.latitude.toString(), longitude = mLastLocation.longitude.toString(),country=country, Locality = locality, Address =addressLine )
                    val trackList = mutableListOf<LocationData>()
                    trackList.add(detail)
                    addDataToDatabase(
                        email = firebaseAuth.currentUser?.email,
                        password = AppPreferences.password.toString(),
                        mapDetail = trackList
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d(TAG, "onLocationResult11: ${e.message}")
            }
        }

    }



    override fun onPause(){
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onStart(){
        super.onStart()
        requestNewLocationData()
        Log.d(TAG, "onStart: ")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }



    fun isLocationEnabled(): Boolean{
        val locationManager: LocationManager = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun checkPermissions(): Boolean {
        return ActivityCompat.checkSelfPermission(this.requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }
    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            permissionId
        )
    }





    override fun onDestroyView() {
        super.onDestroyView()
        mFusedLocationClient.removeLocationUpdates(mLocationCallback)
        handler.removeCallbacks(continuousTask)
        locationDetailAdapter = null
        _binding = null
    }

    companion object{
        const val TAG = "HomeFragment"
        private const val LOCATION_PERMISSION_REQUEST_CODE = 123

    }

    override fun onClick(host: LocationData, position: Int) {

        val location= LocationDetails(
            host.latitude,
            longitude = host.longitude,
            Address =host.Address ,
            Locality = host.Locality,
            country = host.country,
            password = "",
            email = "",)
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMapFragment2(location))
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, start location updates
                Toast.makeText(requireContext(), "update", Toast.LENGTH_SHORT).show()
            } else {
                // Permission denied, handle accordingly
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addDataToDatabase(email: String?, password: String, mapDetail: List<LocationData>) {
        try {
            lifecycleScope.launch(Dispatchers.IO) {


                 realm = Realm.getDefaultInstance()

                // Check if the user already exists in the database
                val existingUser = realm?.where(MapDb::class.java)
                    ?.equalTo("email", email)
                    ?.findFirst()

                realm?.executeTransaction { realm ->
                    if (existingUser == null) {
                        // Create a new user entry in the database
                        val modal = MapDb()
                        val id = realm.where(MapDb::class.java).max("id")
                        val nextId: Long = id?.toLong()?.plus(1) ?: 1

                        modal.id = nextId
                        modal.email = email
                        modal.password = password

                        val trackList = RealmList<LocationData>()
                        trackList.addAll(mapDetail)

                        modal.locationData = trackList
                        realm.copyToRealm(modal)
                        Log.d(TAG, "addDataToDatabase: new user")
                    } else {
                        // User already exists, update the existing entry
                        // existingUser.password = password

                        Log.d(TAG, "addDataToDatabase:exist user ")
                        // Clear existing locationData and add the new data
                        // existingUser.locationData?.clear()
                        existingUser.locationData?.addAll(mapDetail)
                    }
                }

                val filteredList = mutableListOf<MapDb>()
                existingUser?.let { filteredList.add(it) }
                filteredList.forEach {
                    it.locationData?.forEach { it ->
                        locationList?.add(
                            LocationData(
                                latitude = it.latitude,
                                longitude = it.longitude,
                                country = it.country,
                                Locality = it.Locality,
                                Address = it.Address,
                            )
                        )

                        if (filteredList.isNotEmpty()) {
                            mapDetails?.add(
                                PolyLineDetail(
                                    latitude = it.latitude.toDouble(),
                                    longitude = it.longitude.toDouble()
                                )
                            )
                        }
                    }

                }
                withContext(Dispatchers.Main) {
                    // Initialize the adapter once
                    if (locationDetailAdapter == null) {
                        locationDetailAdapter = LocationDetailAdapter(locationList!!, this@HomeFragment)
                        binding.locationListDetail.layoutManager = LinearLayoutManager(requireContext())
                        binding.locationListDetail.setHasFixedSize(true)
                        binding.locationListDetail.adapter = locationDetailAdapter
                    }
                    locationDetailAdapter?.notifyDataSetChanged()

                }

                realm?.close()

            }



        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "addDataToDatabase: Error", e)
        }
    }


}