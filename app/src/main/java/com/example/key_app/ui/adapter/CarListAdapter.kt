package com.example.key_app.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.key_app.databinding.ItemCarBinding
import com.example.key_app.databinding.ItemHeaderBinding
import com.example.key_app.domain.model.CarItem
import com.example.key_app.domain.model.HeaderItem
import com.example.key_app.domain.model.ListItem

private class CarViewHolder(
    private val clickListener : CarListAdapter.OnItemClickListener,
    private val binding : ItemCarBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(carItem : CarItem) {
        binding.apply {
            root.setOnClickListener { clickListener.onUserItemClick(carItem) }
            carTitle.text = carItem.title
        }
    }
}

private class HeaderViewHolder(
    private val binding: ItemHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(headerItem: HeaderItem) {
        binding.apply {
            headerTitle.text = headerItem.title
        }
    }
}

class CarListAdapter  (
    private val clickListener : OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : List<ListItem> = emptyList()

    interface OnItemClickListener {
        fun onUserItemClick(carItem: CarItem)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data : List<ListItem>) {
        items = data
        notifyDataSetChanged()
    }

    private companion object {
        private const val TYPE_CAR = 1
        private const val TYPE_HEADER = 0
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is CarItem -> TYPE_CAR
            is HeaderItem -> TYPE_HEADER
            else -> throw IllegalArgumentException("unexpected")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_CAR -> CarViewHolder(
                clickListener,
                ItemCarBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            TYPE_HEADER -> HeaderViewHolder (
                ItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw IllegalArgumentException("unexpected")
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is CarViewHolder -> holder.bind(item as CarItem)
            is HeaderViewHolder -> holder.bind(item as HeaderItem)
        }
    }
}