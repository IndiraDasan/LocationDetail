package com.example.locationdetail.adapter



import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.locationdetail.databinding.LocationlistviewBinding
import com.example.locationdetail.model.LocationData
import com.example.locationdetail.model.MapDb

class LocationDetailAdapter(private val mList: List<LocationData>, val listener: clickListener
) : RecyclerView.Adapter<LocationDetailAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LocationlistviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    interface clickListener {
        fun onClick(host: LocationData, position: Int)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

            holder.latitude.text = itemsViewModel.latitude
            holder.longitude.text = itemsViewModel.longitude.toString()
            holder.counrtyName.text = itemsViewModel.country.toString()
            holder.location.text = itemsViewModel.Locality.toString()
            holder.address.text = itemsViewModel.Address.toString()


        holder.cardView.setOnClickListener {

            listener.onClick(itemsViewModel, position = position)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(binding: LocationlistviewBinding) : RecyclerView.ViewHolder(binding.root) {
        //val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val latitude: TextView = binding.latitudeValue
        val longitude: TextView = binding.longitudeValue
        val counrtyName: TextView = binding.countyrValue
        val location: TextView = binding.localityValue
        val address: TextView = binding.addressValue
        val cardView: CardView = binding.cardView
    }
}
