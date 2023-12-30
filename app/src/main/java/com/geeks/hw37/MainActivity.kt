package com.geeks.hw37

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.hw37.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(binding.topContainer.id, TopFragment()).commit()
        supportFragmentManager.beginTransaction().add(binding.bottomContainer.id, BottomFragment()).commit()
    }
}