package com.gyant.sdksamplejava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.gyant.chat_sdk.GyantChat;
import com.gyant.chat_sdk.GyantView;

import java.util.HashMap;
import java.util.Map;

public class DisplayGyantViewWithThemeActivity extends AppCompatActivity {
    private GyantView gyantView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        Map<String, String> botPalette = new HashMap<String, String>();
        botPalette.put("primaryColor1","ff0000");

        Map<String, String> providerPalette = new HashMap<String, String>();
        botPalette.put("primaryColor1","00ff00");

        Map<String, Map<String, String>> themeMap = new HashMap<String, Map<String, String>>();
        themeMap.put("bot", botPalette);
        themeMap.put("provider", providerPalette);

        GyantChat gyantChat = GyantChat.getInstance()
                .clientId("client_id")
                .isDev(true)
                .withTheme(themeMap)
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


