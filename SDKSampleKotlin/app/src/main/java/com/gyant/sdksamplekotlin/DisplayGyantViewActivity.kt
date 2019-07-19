package com.gyant.sdksamplekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.gyant.gyantchatsdk.GyantChat

class DisplayGyantViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_gyant_view)


        GyantChat.start( "clientID",  "patientID", true);

        val gyantView = GyantChat.creatView(this, lifecycle);
        val frame = findViewById(R.id.frame_layout) as FrameLayout

        frame.addView(gyantView);
    }
}
