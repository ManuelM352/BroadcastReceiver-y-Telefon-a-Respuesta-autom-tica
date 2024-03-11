package com.example.broadcastreceiver_y_telefona_respuestaautomtica

import android.content.Context
import android.telecom.Call
import android.telecom.CallScreeningService

class CallService : CallScreeningService() {
    override fun onScreenCall(callDetails: Call.Details) {
        val numeroTelefono = callDetails.handle.schemeSpecificPart
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("incomingPhoneNumber", numeroTelefono).apply()
    }
}