package com.gyant.sdksamplekotlin

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

import android.os.Bundle

import com.gyant.gyantchatsdk.GyantChat

class DisplayFragmentActivity : AppCompatActivity() {
    internal var frag: GyantFragment

    override fun onCreate(savedInstanceState: Bundle?) {

        GyantChat.start( "client_id",  "patient_id", true);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_fragment)

        frag = GyantChat.createFragment();

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_layout, frag,  BuildConfig.APPLICATION_ID + ".GyantFragment")
            .commit();
    }

    fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        this.frag.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
