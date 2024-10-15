package com.example.custom_phone_kiosk

import android.app.Service
import android.content.Intent
import android.os.IBinder

class StartAppService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        // Code to start your MainActivity or perform any other action
//        val launchIntent = Intent(this, MainActivity::class.java)
//        launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        startActivity(launchIntent)
//        return START_STICKY
//    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val launchIntent = Intent(this, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(launchIntent)
        return START_STICKY
    }

}
