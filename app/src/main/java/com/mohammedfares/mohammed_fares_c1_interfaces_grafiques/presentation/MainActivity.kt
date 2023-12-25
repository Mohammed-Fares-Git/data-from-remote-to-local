package com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mohammedfares.mohammed_fares_c1_interfaces_grafiques.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}