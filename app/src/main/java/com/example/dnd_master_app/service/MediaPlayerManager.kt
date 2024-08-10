package com.example.dnd_master_app.service

import android.content.Context
import android.media.MediaPlayer
import com.example.dnd_master_app.parent.dto.SoundItem
import com.example.dnd_master_app.utils.DndLog

object MediaPlayerManager {

    private var mediaPlayer: MediaPlayer? = null
    private var currentSound: String? = null

    fun startStop(context: Context, data: SoundItem) {
        DndLog.info("MediaPlayerManager", "start $data")

        // Проверка, проигрывается ли текущий звук и совпадает ли он с данным
        if (data.uuid == currentSound) {
            mediaPlayer?.let {
                if (it.isPlaying) {
                    pause()
                } else {
                    it.start()
                }
            }
            return
        }

        // Если новый звук, то заменяем текущий и начинаем проигрывание
        currentSound = data.uuid
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, data.soundId).apply {
            isLooping = data.isLooping
            start()
        }
    }

    fun play() {
        DndLog.info("MediaPlayerManager", "play")
        mediaPlayer?.start()
    }

    fun pause() {
        DndLog.info("MediaPlayerManager", "pause")
        mediaPlayer?.pause()
    }

    fun stop() {
        DndLog.info("MediaPlayerManager", "stop")
        mediaPlayer?.stop()
        mediaPlayer?.release()
    }
}