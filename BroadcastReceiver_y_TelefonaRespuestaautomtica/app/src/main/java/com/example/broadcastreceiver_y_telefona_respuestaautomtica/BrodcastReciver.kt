package com.example.broadcastreceiver_y_telefona_respuestaautomtica

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.telephony.TelephonyManager
import android.util.Log

class BrodcastReciver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
            if (state == TelephonyManager.EXTRA_STATE_RINGING) {
                // Recupera el número de teléfono
                val numeroTelefono = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                val numeroEntrante = numeroTelefono.getString("LlamadaEntrante", null)
                val numeroDestino = numeroTelefono.getString("numeroDestino", null)
                if (numeroEntrante != null &&  numeroEntrante == numeroDestino) {
                    var smsManager: SmsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(numeroEntrante, null, null, null, null)
                }
            }
        }
    }
}