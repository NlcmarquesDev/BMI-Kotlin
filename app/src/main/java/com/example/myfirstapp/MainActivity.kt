package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        var getHeight: EditText = findViewById(R.id.inputAltura);
        var getWeight :EditText = findViewById(R.id.inputPeso);



        val btn_calc:Button =  findViewById<Button>(R.id.btn_calculate);


        btn_calc.setOnClickListener{

            val heightStr = getHeight.text.toString();
            val weightStr = getWeight.text.toString();

            if(heightStr.isNotEmpty() && weightStr.isNotEmpty()) {

                val heightValue = heightStr.toFloat();
                val weightValue = weightStr.toFloat();

                val height: Float = heightValue * heightValue;
                val weigth: Float = weightValue;

                val result = weigth / height;

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("EXTRA_RESULT", result)
                }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Please insert all the fields", Toast.LENGTH_LONG).show()
            }


        }




    }
}