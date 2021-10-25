package com.example.threadques1

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.example.threadques1.service.BindService
import com.example.threadques1.service.MusicService

class MainActivity : AppCompatActivity() {

    var myService: BindService? = null
    var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        service()
        bindLocalService()
        findViewById<View>(R.id.localServiceBtn).setOnClickListener {
            showTime()
        }
    }
        fun service() {


            val serviceIntent = Intent(this, MusicService::class.java)
            findViewById<View>(R.id.startButton).setOnClickListener {
                startService(serviceIntent)
                Toast.makeText(this, "Music Started", Toast.LENGTH_SHORT).show()
            }
            findViewById<View>(R.id.stopButton).setOnClickListener {
                stopService(serviceIntent)
            }
        }



        fun bindLocalService() {
            val intent = Intent(this, BindService::class.java)
            bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
        }

        fun showTime() {
            val currentTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                myService?.getCurrentTime()
            } else {
                TODO("VERSION.SDK_INT < N")
            }
            Toast.makeText(this, "Current time is: ${currentTime.toString()}", Toast.LENGTH_SHORT)
                .show()
        }

    val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as BindService.MyLocalBinder
            myService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isBound = false
        }
    }
}