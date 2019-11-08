package com.gyant.sdksamplejava;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeToFragmentPage(View view) {
        Intent intent = new Intent(this, DisplayFragmentActivity.class);
        startActivity(intent);
    }
    public void changeToViewPage(View view) {
        Intent intent = new Intent(this, DisplayGyantViewActivity.class);
        startActivity(intent);
    }

    public void changeToActivityPage(View view) {
        Intent intent = new Intent(this, DisplayGyantChatActivity.class);
        startActivity(intent);
    }

    public void changeToViewWithThemePage(View view) {
        Intent intent = new Intent(this, DisplayGyantViewWithThemeActivity.class);
        startActivity(intent);
    }

    public void changeToViewWithMessageListener(View view) {
        Intent intent = new Intent(this, DisplayGyantViewWithMessageListenerActivity.class);
        startActivity(intent);
    }

    public void changeToViewWithPushToken(View view) {
        Intent intent = new Intent(this, DisplayGyantViewWithPushTokenActivity.class);
        startActivity(intent);
    }
}
