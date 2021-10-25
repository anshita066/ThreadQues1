package com.example.threadques1.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.widget.Toast

class Phone :BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p1?.getStringExtra(TelephonyManager.EXTRA_STATE)
            .equals(TelephonyManager.EXTRA_STATE_RINGING)
        ) {
            Toast.makeText(p0, "Incoming Call", Toast.LENGTH_SHORT).show()
        }
    }
}