package com.example.ivyaan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ivyaan.databinding.ActivityMainBinding

// ignore this class, not useful
class MainActivity : AppCompatActivity() {
    private val TAG = "YKB"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Call the static inflate() method included in the generated binding class.
        // This creates an instance of the binding class for the activity to use.
        // Note: The inflate() method requires you to pass in a layout inflater.
        // If the layout is already inflated, you can instead call the binding class's static bind() method.
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        val helloWorldTextView = binding.helloWorld
        setContentView(rootView)
    }

    override fun onResume() {
        super.onResume()

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        Log.i(TAG, "onResume end")
    }
}

























