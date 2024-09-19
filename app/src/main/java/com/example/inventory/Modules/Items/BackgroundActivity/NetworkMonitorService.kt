package com.example.inventory.Modules.BackgroundActivity

import android.app.Service
import android.content.Intent
import android.os.IBinder

class NetworkMonitorService : Service() {

    private lateinit var networkChangeListener: NetworkChangeListener

    override fun onCreate() {
        super.onCreate()
        println("NetworkMonitorService onCreate")
        networkChangeListener = NetworkChangeListener(this, this@NetworkMonitorService)
        networkChangeListener.checkNetworkConnection()
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("NetworkMonitorService onBind")
        return null
    }


}
