package com.example.key_app.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.key_app.R
import com.example.key_app.databinding.FragmentMapBinding
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.geometry.LatLngBounds

class MapFragment : Fragment(R.layout.fragment_map) {

    private val args : MapFragmentArgs by navArgs()

    private var _binding : FragmentMapBinding? = null
    val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUi()
    }

    private fun setUi() {
        binding.apply {
            mapView.getMapAsync {map ->
                map.setStyle("https://maps.starline.ru/mapstyles/default/style.json")

                val markerOptions = MarkerOptions()
                    .position(LatLng(args.car.lat, args.car.lon))
                    .title(args.car.title)
                map.addMarker(markerOptions)

                map.getCameraForLatLngBounds(LatLngBounds.fromLatLngs(listOf(LatLng(args.car.lat, args.car.lon))))?.let {
                    val newCameraPosition = CameraPosition.Builder()
                        .target(it.target)
                        .zoom(it.zoom - 10)
                        .build()
                    map.cameraPosition = newCameraPosition
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}