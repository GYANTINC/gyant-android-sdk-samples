package com.gyant.sdksamplejava;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.gyant.chat_sdk.GyantChat;
import com.gyant.chat_sdk.GyantFragment;

public class DisplayFragmentActivity extends AppCompatActivity {
    GyantFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_fragment);

        GyantChat gyantChat =  GyantChat.getInstance()
                .clientId("client_id")
                .patientId("patient_id").isDev(true).start();

        frag = gyantChat.createFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout, frag,  BuildConfig.APPLICATION_ID + ".GyantFragment")
                .commit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        this.frag.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
