package com.example.threadques1.service

import android.app.Service
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import java.util.*

class BindService : Service(){
    private val myBinder = MyLocalBinder()

    class MyLocalBinder: Binder() {
        fun getService(): BindService {
            return BindService()
        }
    }



    fun getCurrentTime(): String {
        val dateformat = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            SimpleDateFormat(
                "HH:mm:ss MM/dd/yyyy",
                Locale.US
            )
        } else {
            TODO("VERSION.SDK_INT < N")
        }
        return dateformat.format(Date())
    }


    override fun onBind(intent: Intent?): IBinder? {
        return myBinder
    }
}