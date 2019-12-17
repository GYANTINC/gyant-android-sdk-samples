package com.gyant.sdksamplekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
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

    fun changeToViewWithListenerPage(view: View) {
        val intent = Intent(this, DisplayGyantViewWithListenerActivity::class.java)
        startActivity(intent)
    }

    fun changeToViewWithPatientDataPage(view: View) {
        val intent = Intent(this, DisplayGyantViewWithPatientDataActivity::class.java)
        startActivity(intent)
    }

}
