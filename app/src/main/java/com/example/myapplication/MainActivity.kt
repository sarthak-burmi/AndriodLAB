package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private val CORRECT_PASSWORD = "password123"
    private val CORRECT_username = "sarthak"

    private var remainingAttempts = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.button_show_toast)

        buttonLogin.setOnClickListener {
            val enteredPassword = editTextPassword.text.toString()
            val enteredUsername = editTextUsername.text.toString()

            if (enteredPassword == CORRECT_PASSWORD && enteredUsername == CORRECT_username) {
                //Toast.makeText(this@MainActivity, "Hurray! You have passed the verification.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, homePage::class.java)
                startActivity(intent)
            } else {
                remainingAttempts--
                if (remainingAttempts > 0) {
                    Toast.makeText(this@MainActivity, "Wrong password and username You have $remainingAttempts attempts remaining.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "You have exhausted the limit. Try again after some time.", Toast.LENGTH_SHORT).show()
                    buttonLogin.isEnabled = false
                }
            }
        }
    }
}
