package com.gyant.sdksamplejava;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import com.gyant.gyantchatsdk.GyantChat;
import com.gyant.gyantchatsdk.GyantView;

public class DisplayGyantViewActivity extends AppCompatActivity {
    GyantView gyantView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_gyant_view);

        GyantChat gyantChat = GyantChat.getInstance()
                .clientId("client_id")
                .patientId("patient_id")
                .isDev(true).start();

        this.gyantView = gyantChat.createView(this, getLifecycle());

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        frameLayout.addView(gyantView);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        this.gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    void changePatientId(View view) {
        GyantChat.getInstance().changePatientId("new_patient_id");
    }
}
