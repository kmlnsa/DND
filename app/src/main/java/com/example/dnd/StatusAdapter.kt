package com.example.dnd

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd.data.model.Entity
import com.example.dnd.databinding.ItemStatusBinding

open class StatusAdapter : ListAdapter<Entity, StatusAdapter.StatusViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        return StatusViewHolder(
            ItemStatusBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        )
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int){
        holder.bind(getItem(position))
    }

    class StatusViewHolder(
        private val binding: ItemStatusBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Entity){
            binding.health.text = item.health.toString()
            binding.attack.text = item.attack.toString()
            binding.protection.text = item.protection.toString()
            binding.damage.text = item.damage.toString()
            if (item.health == 0){
                binding.health.text = false.toString()
            }
        }
    }
}


