package com.example.myfirstapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled( true)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvResult = findViewById<TextView>(R.id.textview_result);
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        tvResult.text= result.toString();

        val classification = if(result <18.5f){
            "UNDERWEIGHT"

        } else if( result >=18.5f && result < 24.9f){
            "NORMAL"
        } else if(result >=24.9f && result < 29.9f){
            "OVERWEIGHT"
        }else if(result >=29.9f && result < 39.9f){
            "OBESITY"
        }else {
            "SEVERE OBESITY"
        }

        val  txtClassif = findViewById<TextView>(R.id.txt_classification)
        txtClassif.text = getString(R.string.msg_result, classification)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}