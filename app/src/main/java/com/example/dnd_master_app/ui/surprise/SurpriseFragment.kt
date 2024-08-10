package com.example.dnd_master_app.ui.surprise

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd_master_app.databinding.FragmentSurpriseBinding
import com.example.dnd_master_app.parent.AbstractSoundFragment
import com.example.dnd_master_app.parent.dto.SoundItem

class SurpriseFragment : AbstractSoundFragment<FragmentSurpriseBinding>() {

    override fun sounds(): List<SoundItem> {
        return listOf(

        )
    }

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?): FragmentSurpriseBinding {
        return FragmentSurpriseBinding.inflate(inflater, container, false)
    }

    override fun soundList(binding: FragmentSurpriseBinding): RecyclerView {
        return binding.soundList
    }

}