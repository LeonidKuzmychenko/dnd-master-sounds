package com.example.dnd_master_app.parent.dto

import java.util.UUID

data class SoundItem(
    val imageId: Int,
    val soundId: Int,
    val title: String,
    val isLooping: Boolean = false,
    val uuid: String = UUID.randomUUID().toString()
)