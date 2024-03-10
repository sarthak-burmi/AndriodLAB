package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class homePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page_main)

        val maleRadioButton = findViewById<RadioButton>(R.id.maleRB)
        val femaleRadioButton = findViewById<RadioButton>(R.id.femaleRB)
        val lang1CheckBox = findViewById<CheckBox>(R.id.lang1)
        val lang2CheckBox = findViewById<CheckBox>(R.id.lang2)
        val lang3CheckBox = findViewById<CheckBox>(R.id.lang3)
        val getStartedButton = findViewById<Button>(R.id.welcomeButton)
        val genderRadioGroup = findViewById<RadioGroup>(R.id.genderRadioGroup)
        val textView = findViewById<TextView>(R.id.display_male_lang)

        getStartedButton.setOnClickListener {

            val selectedGender = when (genderRadioGroup.checkedRadioButtonId) {
                R.id.maleRB -> "Male"
                R.id.femaleRB -> "Female"
                else -> null
            }

            val selectedLanguages = mutableListOf<String>()
            if (lang1CheckBox.isChecked) selectedLanguages.add("English")
            if (lang2CheckBox.isChecked) selectedLanguages.add("Hindi")
            if (lang3CheckBox.isChecked) selectedLanguages.add("German")
            val toastMessage = when {
                selectedGender == null -> "Please select the gender"
                selectedLanguages.isEmpty() -> "Please select at least one language"
                else -> "Selected gender: $selectedGender\nSelected languages: ${selectedLanguages.joinToString()}"
            }
            textView.setText("Selected gender: $selectedGender\n\nSelected languages: ${selectedLanguages.joinToString()}")

            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
