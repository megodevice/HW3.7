package com.geeks.hw37

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.geeks.hw37.databinding.ActivityPromotionBinding

class PromotionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPromotionBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPromotionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvSongName.text =
            intent.getSerializableExtra(BottomFragment.SONG, Song::class.java)?.name
    }
}