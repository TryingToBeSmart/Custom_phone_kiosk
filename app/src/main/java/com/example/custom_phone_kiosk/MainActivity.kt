package com.example.custom_phone_kiosk

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCall: Button
    private lateinit var buttonText: Button

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        // Do nothing
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCall = findViewById(R.id.buttonCall)
        buttonText = findViewById(R.id.buttonText)

//      Open phone call app
        buttonCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }

//      Open text message app
        buttonText.setOnClickListener {
            val smsIntent = Intent(Intent.ACTION_MAIN).apply {
                addCategory(Intent.CATEGORY_APP_MESSAGING) // This ensures only SMS apps handle it
            }

            // Check if there is an app that can handle this intent
            if (smsIntent.resolveActivity(packageManager) != null) {
                startActivity(smsIntent)
            } else {
                // Handle case where no SMS app is available
                Toast.makeText(this, "No SMS app found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
