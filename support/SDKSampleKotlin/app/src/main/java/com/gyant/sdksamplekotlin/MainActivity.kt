package com.gyant.sdksamplekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

@Suppress("UNUSED_PARAMETER")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeToFragmentPage(view: View) {
        val intent = Intent(this, DisplayFragmentActivity::class.java)
        startActivity(intent)
    }

    fun changeToViewPage(view: View) {
        val intent = Intent(this, DisplayGyantViewActivity::class.java)
        startActivity(intent)
    }

    fun changeToActivityPage(view: View) {
        val intent = Intent(this, DisplayGyantChatActivity::class.java)
        startActivity(intent)
    }

    fun changeToViewWithThemePage(view: View) {
        val intent = Intent(this, DisplayGyantViewWithThemeActivity::class.java)
        startActivity(intent)
    }

    fun changeToViewWithMessageListener(view: View) {
        val intent = Intent(this, DisplayGyantViewWithMessageListener::class.java)
        startActivity(intent)
    }

    fun changeToViewWithPushToken(view: View) {
        val intent = Intent(this, DisplayGyantViewWithPushTokenActivity::class.java)
        startActivity(intent)
    }

}
