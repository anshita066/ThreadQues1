package com.example.threadques1.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Battery : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val battery = p1?.getIntExtra("level",0)?: return
        if (battery!=0){
            Toast.makeText(p0, "Batter percentage $battery%", Toast.LENGTH_SHORT).show()
        }
    }


}