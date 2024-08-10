package com.example.dnd_master_app.ui.door

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd_master_app.R
import com.example.dnd_master_app.databinding.FragmentDoorBinding
import com.example.dnd_master_app.parent.AbstractSoundFragment
import com.example.dnd_master_app.parent.dto.SoundItem

class DoorFragment : AbstractSoundFragment<FragmentDoorBinding>() {

    override fun sounds(): List<SoundItem> {
        return listOf(
            SoundItem(R.drawable.break_door_image, R.raw.break_door_sound, "Выбивание двери"),
            SoundItem(R.drawable.explosion_door_image, R.raw.explosion_sound, "Взрыв двери"),
            SoundItem(R.drawable.creaking_door_image, R.raw.creaking_door_sound, "Скрип открытия двери"),
            SoundItem(R.drawable.knock_door_image, R.raw.knock_door_sound, "Стук в дверь")
        )
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?): FragmentDoorBinding {
        return FragmentDoorBinding.inflate(inflater, container, false);
    }

    override fun soundList(binding: FragmentDoorBinding): RecyclerView {
        return binding.soundList
    }

}