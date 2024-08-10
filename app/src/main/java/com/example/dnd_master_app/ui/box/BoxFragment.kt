package com.example.dnd_master_app.ui.box

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd_master_app.R
import com.example.dnd_master_app.databinding.FragmentBoxBinding
import com.example.dnd_master_app.parent.AbstractSoundFragment
import com.example.dnd_master_app.parent.dto.SoundItem

class BoxFragment : AbstractSoundFragment<FragmentBoxBinding>() {

    override fun sounds(): List<SoundItem> {
        return listOf(
            SoundItem(R.drawable.open_box_image, R.raw.creaking_door_sound, "Скрип открытия сундука"),
            SoundItem(R.drawable.explosion_box_image, R.raw.explosion_sound, "Взрыв сундука")
        )
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?): FragmentBoxBinding {
        return FragmentBoxBinding.inflate(inflater, container, false);
    }

    override fun soundList(binding: FragmentBoxBinding): RecyclerView {
        return binding.soundList
    }

}