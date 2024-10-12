package com.example.custom_phone_kiosk

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextPhoneNumber: EditText
    private lateinit var buttonCall: Button
    private lateinit var buttonText: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        buttonCall = findViewById(R.id.buttonCall)
        buttonText = findViewById(R.id.buttonText)

        buttonCall.setOnClickListener {
            val phoneNumber = editTextPhoneNumber.text.toString()
            if (phoneNumber.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(intent)
            }
        }

        buttonText.setOnClickListener {
            val phoneNumber = editTextPhoneNumber.text.toString()
            if (phoneNumber.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("smsto:$phoneNumber") // Only SMS apps should handle this
                startActivity(intent)
            }
        }
    }
}
