package com.example.dnd_master_app.utils

import android.util.Log

object DndLog {

    fun info(tag: String, message: String) {
        Log.i("DND_LOG_$tag", message)
    }
}