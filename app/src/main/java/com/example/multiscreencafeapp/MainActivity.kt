package com.example.multiscreencafeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object{
        const val KEY = "com.example.multiscreencafeapp.KEY"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val eT1 = findViewById<TextView>(R.id.eT1)
        val eT2 = findViewById<TextView>(R.id.eT2)
        val eT3 = findViewById<TextView>(R.id.eT3)
        val eT4 = findViewById<TextView>(R.id.eT4)

        btnOrder.setOnClickListener{
            val orderPlaced = "1." + eT1.text.toString() + "\n2." + eT2.text.toString() + "\n3."+ eT3.text.toString() + "\n4."+eT4.text.toString()

            intent = Intent(this,ShowOrder::class.java)
            intent.putExtra(KEY, orderPlaced)
            startActivity(intent)
        }
    }
}