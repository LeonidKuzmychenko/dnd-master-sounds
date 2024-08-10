package com.example.dnd_master_app.ui.environment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd_master_app.R
import com.example.dnd_master_app.databinding.FragmentEnvironmentBinding
import com.example.dnd_master_app.parent.AbstractSoundFragment
import com.example.dnd_master_app.parent.dto.SoundItem

class EnvironmentFragment : AbstractSoundFragment<FragmentEnvironmentBinding>() {

    override fun sounds(): List<SoundItem> {
        return listOf(
            SoundItem(R.drawable.forest_image, R.raw.forest_sound, "Лес", true),
            SoundItem(R.drawable.battle_image, R.raw.battle_sound, "Бой", true),
            SoundItem(R.drawable.rain_image, R.raw.rain_sound, "Дождь", true)
        )
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?): FragmentEnvironmentBinding {
        return FragmentEnvironmentBinding.inflate(inflater, container, false);
    }

    override fun soundList(binding: FragmentEnvironmentBinding): RecyclerView {
        return binding.soundList
    }

}