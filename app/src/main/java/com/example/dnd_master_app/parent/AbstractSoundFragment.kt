package com.example.dnd_master_app.parent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.dnd_master_app.parent.adapter.SoundAdapter
import com.example.dnd_master_app.parent.adapter.SoundController
import com.example.dnd_master_app.parent.dto.SoundItem
import com.example.dnd_master_app.utils.GridSpacingItemDecoration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class AbstractSoundFragment<T : ViewBinding> : Fragment() {

    private var _binding: T? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = inflate(inflater, container)
        val root: View = binding.root
        soundList(binding).layoutManager = GridLayoutManager(this.context, 2)
        soundList(binding).addItemDecoration(GridSpacingItemDecoration(2, 0, false))
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            val soundController: SoundController = (requireActivity() as SoundController)
            soundList(binding).adapter = SoundAdapter(sounds(), soundController)
        }
    }

    override fun onPause() {
        super.onPause()
        Log.e(this.javaClass.name, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(this.javaClass.name, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(this.javaClass.name, "onDestroyView")
        _binding = null
    }

    override fun onDetach() {
        Log.e(this.javaClass.name, "onDetach")
        super.onDetach()
    }

    abstract fun sounds(): List<SoundItem>

    abstract fun inflate(inflater: LayoutInflater, container: ViewGroup?): T

    abstract fun soundList(binding: T): RecyclerView
}