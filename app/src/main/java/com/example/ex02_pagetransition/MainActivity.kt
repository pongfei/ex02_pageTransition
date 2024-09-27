package com.example.ex02_pagetransition

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

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

        val mainText = findViewById<EditText>(R.id.mainEditText)
        val go2DetailBtn = findViewById<Button>(R.id.go2DetailBtn)
        val resultEditText = findViewById<EditText>(R.id.resultEditText)

        //receive
        val bundle = intent.extras
        var detail1 = ""
        var detail2 = ""
        if(bundle != null){
            detail1 = bundle.getString("input1").toString()
            detail2 = bundle.getString("input2").toString()
        }

        //to show
        var result =(detail1 + " " + detail2)
        resultEditText.setText(result)

        go2DetailBtn.setOnClickListener{
            //to send data (inside intent)
            val intent = Intent(this, DetailActivity::class.java) //where to
            intent.putExtra("mainText",mainText.text.toString()) //what is sent
            startActivity(intent)
        }

    }
}

