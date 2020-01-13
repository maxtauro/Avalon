package com.maxtauro.avalon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.main_text).text = createApplicationScreenMessage()

        findViewById<Button>(R.id.test_button).text = createApplicationScreenMessage()

        findViewById<Button>(R.id.test_button).setOnClickListener {
            postFirebaseHelloWorld()
        }
    }
}
