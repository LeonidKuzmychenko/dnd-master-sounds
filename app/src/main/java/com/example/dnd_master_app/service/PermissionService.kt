package com.example.dnd_master_app.service

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.Activity
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.TIRAMISU
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat.checkSelfPermission
import com.example.dnd_master_app.broadcast.MyBroadcastReceiver

class PermissionService {

    private val REQUEST_CODE_POST_NOTIFICATIONS = 1001

    fun checkPermission(activity: Activity) {
        if (SDK_INT >= TIRAMISU) {
//            val intentFilter = IntentFilter().apply {
//                addAction("ACTION_PLAY")
//                addAction("ACTION_PAUSE")
//            }
//            activity.registerReceiver(
//                MyBroadcastReceiver(),
//                intentFilter,
//                Context.RECEIVER_NOT_EXPORTED
//            )
            if (!isGranted(activity, POST_NOTIFICATIONS)) {
                requestPermissions(
                    activity,
                    arrayOf(POST_NOTIFICATIONS),
                    REQUEST_CODE_POST_NOTIFICATIONS
                )
            }
        }

    }

    private fun isGranted(activity: Activity, permission: String): Boolean {
        return checkSelfPermission(activity, permission) == PERMISSION_GRANTED
    }

}