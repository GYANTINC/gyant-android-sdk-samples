package com.gyant.sdksamplejava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.gyant.gyantchatsdk.GyantChat;

public class DisplayGyantViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_gyant_view);

        GyantChat.start( "client_id",  "patient_id", true);

        View gyantView = GyantChat.creatView(this, getLifecycle());

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        frameLayout.addView(gyantView);
    }


}
