package com.gyant.sdksamplejava;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.gyant.gyantchatsdk.GyantChat;

public class DisplayFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_fragment);

        GyantChat.start( "client_id",  "patient_id", true);

        Fragment frag = GyantChat.createFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout, frag,  BuildConfig.APPLICATION_ID + ".GyantFragment")
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
