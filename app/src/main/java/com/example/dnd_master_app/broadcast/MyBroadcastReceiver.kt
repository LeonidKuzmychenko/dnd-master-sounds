package com.example.dnd_master_app.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.dnd_master_app.service.MediaPlayerManager
import com.example.dnd_master_app.utils.DndLog

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        DndLog.info("MyBroadcastReceiver", "onReceive")
        when (intent.action) {
            "ACTION_PLAY" -> {
                DndLog.info("MyBroadcastReceiver", "ACTION_PLAY")
                MediaPlayerManager.play()
            }
            "ACTION_PAUSE" -> {
                DndLog.info("MyBroadcastReceiver", "ACTION_PAUSE")
                MediaPlayerManager.pause()
            }
            "ACTION_STOP" -> {
                DndLog.info("MyBroadcastReceiver", "ACTION_STOP")
                MediaPlayerManager.stop()
            }
        }
    }
}