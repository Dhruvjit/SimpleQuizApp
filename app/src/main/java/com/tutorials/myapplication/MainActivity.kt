package com.tutorials.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart:Button = findViewById(R.id.btn_start)
        val etName:EditText = findViewById(R.id.et_name)
        btnStart.setOnClickListener {
            if(etName.text.isEmpty()){
                Toast.makeText(this, "Please enter your name, it cannot be empty", Toast.LENGTH_LONG).show()
            }else{
                /* create intent that lets us move from current activity to the next quiz activity */
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                /* start the next activity but do not close the previous one */
                startActivity(intent)
                /* finish the current activity or screen and don't let user navigate back by using back button */
                finish()
            }
        }
    }
}