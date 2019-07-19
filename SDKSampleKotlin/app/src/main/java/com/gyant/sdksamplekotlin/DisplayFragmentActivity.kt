package com.gyant.sdksamplekotlin

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

import android.os.Bundle

import com.gyant.gyantchatsdk.GyantChat

class DisplayFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        GyantChat.start( "clientID",  "patientID", true);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_fragment)

        val frag = GyantChat.createFragment();

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout, frag,  BuildConfig.APPLICATION_ID + ".GyantFragment")
            .commit();
    }
}
