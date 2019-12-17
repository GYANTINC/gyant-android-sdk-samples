package com.gyant.sdksamplejava;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.gyant.chat_sdk.GyantChat;
import com.gyant.chat_sdk.GyantChatPatientData;
import com.gyant.chat_sdk.GyantView;

public class DisplayGyantViewWithPatientDataActivity extends AppCompatActivity {

    GyantView gyantView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        GyantChatPatientData patientData = new GyantChatPatientData();
        patientData.patientId = "<YOUR-PATIENT-ID>";
        patientData.visitReason = "fever";
        patientData.gender = "male";
        patientData.dateOfBirth = "2001-03-26T20:28:32.383+0000";

        GyantChat gyantChat = GyantChat.getInstance()
                .clientId("client_id")
                .patientData(patientData)
                .isDev(true)
                .start();

        this.gyantView = gyantChat.createView(this, getLifecycle());

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        frameLayout.addView(gyantView);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        this.gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}


