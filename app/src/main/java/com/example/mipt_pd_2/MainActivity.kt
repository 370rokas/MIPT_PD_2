package com.example.mipt_pd_2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val calc = Calculator()

        val choices = resources.getStringArray(R.array.choices);

        val inputText = findViewById<EditText>(R.id.inputText);
        val typeSelector = findViewById<Spinner>(R.id.typeSelector);
        val calculateBtn = findViewById<Button>(R.id.calculateBtn);
        val resultText = findViewById<TextView>(R.id.resultText);

        inputText.setText(R.string.placeholder);
        calculateBtn.setText(R.string.button);

        // https://www.geeksforgeeks.org/kotlin/spinner-in-kotlin/
        if (typeSelector != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, choices);
            typeSelector.setAdapter(adapter);
        }

        calculateBtn.setOnClickListener {
            // https://stackoverflow.com/a/46047386
            val text = inputText.getText().toString();

            // https://stackoverflow.com/a/7486969
            val calcTypeText: String = typeSelector.getSelectedItem().toString();

            if (text.trim().length > 0 && calcTypeText.trim().length > 0) {
                var resCount: Number = 0;

                if (calcTypeText == "Sakiniai") {
                    resCount = calc.sentences(text);
                } else if (calcTypeText == "Žodžiai") {
                    resCount = calc.words(text);
                } else if (calcTypeText == "Skyryba") {
                    resCount = calc.punctuation(text);
                } else if (calcTypeText == "Skaičiai") {
                    resCount = calc.numbers(text);
                }

                // https://stackoverflow.com/a/3656409
                resultText.text = resources.getString(
                    R.string.result,
                    resCount.toInt()
                );
            } else {
                // https://stackoverflow.com/a/3504538
                Toast.makeText(this, R.string.error,
                    Toast.LENGTH_LONG).show();
            }
        }
    }
}