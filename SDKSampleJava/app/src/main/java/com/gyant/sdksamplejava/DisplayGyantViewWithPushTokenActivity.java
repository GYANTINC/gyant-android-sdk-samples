package com.gyant.sdksamplejava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.gyant.gyantchatsdk.GyantChat;
import com.gyant.gyantchatsdk.GyantOnPushTokenListener;
import com.gyant.gyantchatsdk.CompletionHandler;
import com.gyant.gyantchatsdk.GyantView;


public class DisplayGyantViewWithPushTokenActivity extends AppCompatActivity implements GyantOnPushTokenListener{
    GyantView gyantView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_gyant_view);

        GyantChat gyantChat = GyantChat.getInstance()
                .clientId("client_id")
                .patientId("patient_id")
                .setOnPushTokenListener(this)
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


    @Override
    public void getToken(CompletionHandler callback){
        callback.onComplete("token123");
    }
}
