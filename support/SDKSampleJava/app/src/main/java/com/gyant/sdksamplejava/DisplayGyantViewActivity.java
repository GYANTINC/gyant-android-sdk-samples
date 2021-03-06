package com.gyant.sdksamplejava;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import com.gyant.chat_sdk.GyantChat;
import com.gyant.chat_sdk.GyantView;

public class DisplayGyantViewActivity extends AppCompatActivity {
    private GyantView gyantView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        GyantChat gyantChat = GyantChat.getInstance()
                .clientId("client_id")
                .isDev(true)
                .start();

        gyantView = gyantChat.createView(this, getLifecycle());

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        frameLayout.addView(gyantView);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        gyantView.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
