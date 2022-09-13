package com.harsh.greaternumber

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var btnLeft : Button
    lateinit var btnRight : Button
    lateinit var constLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLeft = findViewById(R.id.buttonLeft)
        btnRight = findViewById(R.id.buttonRight)
        constLayout = findViewById(R.id.layout)
        assignRandom()
        btnLeft.setOnClickListener {
            onClick(Integer.parseInt(btnLeft.text.toString()), Integer.parseInt(btnRight.text.toString()))
            assignRandom()
        }
        btnRight.setOnClickListener {
            onClick(Integer.parseInt(btnRight.text.toString()), Integer.parseInt(btnLeft.text.toString()))
            assignRandom()
        }

    }

    private fun onClick(num1: Int, num2 : Int){
        if(num1>num2){
            Toast.makeText(this,"Correct", LENGTH_SHORT).show()
            constLayout.setBackgroundColor(Color.GREEN)
        }
        else{
            Toast.makeText(this,"Wrong", LENGTH_SHORT).show()
            constLayout.setBackgroundColor(Color.RED)
        }

    }
    private fun assignRandom(){
        val r = Random
        var right = r.nextInt(50)
        val left = r.nextInt(50)
        btnLeft.text = left.toString()
        while(right == left)
            right = r.nextInt(50)
        btnRight.text = right.toString()
    }
}