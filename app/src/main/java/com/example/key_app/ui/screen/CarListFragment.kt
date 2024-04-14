package com.example.key_app.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.key_app.R
import com.example.key_app.databinding.FragmentCarListBinding
import com.example.key_app.domain.model.CarItem
import com.example.key_app.ui.adapter.CarListAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CarListFragment : DaggerFragment(R.layout.fragment_car_list) {

    private val adapter = CarListAdapter(object : CarListAdapter.OnItemClickListener {
        override fun onUserItemClick(carItem: CarItem) {
            val direction = CarListFragmentDirections.actionCarListFragmentToMapFragment(carItem)
            findNavController().navigate(direction)
        }
    })

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var _binding : FragmentCarListBinding? = null
    val binding
        get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SharedViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getLocalData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUi()
        viewModel.listItemLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    private fun setUi() {
        binding.apply {
            carList.layoutManager = LinearLayoutManager(requireContext())
            carList.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}