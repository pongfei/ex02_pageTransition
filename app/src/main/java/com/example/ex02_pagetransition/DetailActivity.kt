package com.example.ex02_pagetransition

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val detailText = findViewById<EditText>(R.id.detailEditText)
        val inputText = findViewById<EditText>(R.id.inputEditText)
        val back2MainBtn = findViewById<Button>(R.id.back2MainBtn)

        val bundle = intent.extras
        var inp1 = ""


        if (bundle != null){
            inp1 = bundle.getString("mainText").toString()
        }
        detailText.setText(inp1)

        back2MainBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("input1",detailText.text.toString())
            intent.putExtra("input2",inputText.text.toString())
            startActivity(intent) //this will not close this page

//            finish() //to close the page
        }
    }
}