package com.example.dnd_master_app.parent.adapter

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd_master_app.databinding.SoundItemBinding
import com.example.dnd_master_app.parent.dto.SoundItem
import com.squareup.picasso.Picasso

class SoundAdapter(
    private val dataList: List<SoundItem>,
    private val soundController: SoundController
) : RecyclerView.Adapter<SoundAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: SoundItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SoundItem) {
            binding.soundItemTitle.text = data.title
            Picasso.get().load(data.imageId).into(binding.soundItemImage)

            binding.soundCard.setOnClickListener {
                soundController.changeSound(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflate = SoundItemBinding.inflate(inflater, parent, false);
        return ItemViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}