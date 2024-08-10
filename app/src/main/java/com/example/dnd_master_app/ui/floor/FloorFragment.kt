package com.example.dnd_master_app.ui.floor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd_master_app.databinding.FragmentFloorBinding
import com.example.dnd_master_app.parent.AbstractSoundFragment
import com.example.dnd_master_app.parent.dto.SoundItem

class FloorFragment : AbstractSoundFragment<FragmentFloorBinding>() {

    override fun sounds(): List<SoundItem> {
        return listOf(

        )
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?): FragmentFloorBinding {
        return FragmentFloorBinding.inflate(inflater, container, false)
    }

    override fun soundList(binding: FragmentFloorBinding): RecyclerView {
        return binding.soundList
    }

}