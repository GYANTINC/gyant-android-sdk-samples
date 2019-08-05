package com.gyant.sdksamplekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.gyant.gyantchatsdk.GyantChat

class DisplayGyantViewActivity : AppCompatActivity() {
    internal var gyantView: GyantView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_gyant_view)


        GyantChat.start( "client_id",  "patient_id", true);

        gyantView = GyantChat.creatView(this, lifecycle);

        val frame = findViewById(R.id.frame_layout) as FrameLayout
        frame.addView(gyantView);
    }

    fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        this.gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
