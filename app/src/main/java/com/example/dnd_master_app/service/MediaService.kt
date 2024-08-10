package com.example.dnd_master_app.service

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.media.app.NotificationCompat.MediaStyle
import com.example.dnd_master_app.R
import com.example.dnd_master_app.broadcast.MyBroadcastReceiver
import com.example.dnd_master_app.parent.adapter.SoundController
import com.example.dnd_master_app.parent.dto.SoundItem

class MediaService(val context: Context) : SoundController {

    @SuppressLint("MissingPermission")
    fun createMediaNotification(data: SoundItem) {
        val channelId = "media_playback_channel"
        val notificationId = 456 // Уникальный идентификатор уведомления

        // Создаем канал уведомлений (для Android 8.0+)
        val channel = NotificationChannel(
            channelId,
            "Media Playback",
            NotificationManager.IMPORTANCE_LOW
        )
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        // Создаем действия для управления медиаплеером
        val playIntent = Intent(context, MyBroadcastReceiver::class.java).apply {
            action = "ACTION_PLAY"
            putExtra("SOUND_ID", data.soundId)
        }
        val playPendingIntent =
            PendingIntent.getBroadcast(context, 0, playIntent, PendingIntent.FLAG_IMMUTABLE)

        val pauseIntent = Intent(context, MyBroadcastReceiver::class.java).apply {
            action = "ACTION_PAUSE"
            putExtra("SOUND_ID", data.soundId)
        }
        val pausePendingIntent =
            PendingIntent.getBroadcast(context, 1, pauseIntent, PendingIntent.FLAG_IMMUTABLE)

        val largeIcon = BitmapFactory.decodeResource(context.resources, data.imageId)

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.logo)
            .setContentTitle(data.title)
//            .setContentText(data.title)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setLargeIcon(largeIcon)
            .setStyle(
                MediaStyle().setShowActionsInCompactView(0, 1) // Показать кнопки управления в свернутом виде
            )
            .addAction(R.drawable.media_play, "Play", playPendingIntent) // Кнопка Play
            .addAction(R.drawable.media_pause, "Pause", pausePendingIntent) // Кнопка Pause
            .setOngoing(true) // Уведомление не закрывается свайпом


        // Отправляем уведомление
        with(NotificationManagerCompat.from(context)) {
            notify(notificationId, builder.build())
        }
    }

    override fun changeSound(data: SoundItem) {
        MediaPlayerManager.startStop(context, data)
        createMediaNotification(data)
    }
}