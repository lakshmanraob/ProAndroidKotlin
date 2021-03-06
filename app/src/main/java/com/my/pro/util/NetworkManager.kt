package com.my.pro.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkManager(private var applicationContext: Context) {

    private var status: Boolean? = false

    val isConnectedToInternet: Boolean?
        get() {
            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val ni = conManager.activeNetworkInfo

            return ni != null && ni.isConnected
        }
}