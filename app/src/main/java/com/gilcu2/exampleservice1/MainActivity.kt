package com.gilcu2.exampleservice1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //starting service 1
        findViewById(R.id.start_service).setOnClickListener {
            val intent = Intent(this@MainActivity, HelloService::class.java)
            startService(intent)
        }


        //service onDestroy callback method will be called
        findViewById(R.id.stop_Service).setOnClickListener {
            val intent = Intent(this@MainActivity, HelloService::class.java)
            stopService(intent)
        }

    }
}
