package com.geeks.hw37

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.hw37.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listSongs = ArrayList<Song>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (listSongs.isEmpty()) loadData(listSongs)
        supportFragmentManager.beginTransaction()
            .add(binding.topContainer.id, TopFragment(listSongs[0])).commit()
        supportFragmentManager.beginTransaction()
            .add(binding.bottomContainer.id, BottomFragment(listSongs, this::onItemClick)).commit()
    }

    private fun onItemClick(position: Int) {
        val intent = Intent(this, PromotionActivity::class.java)
        intent.putExtra(SONG, listSongs[position])
        (supportFragmentManager.findFragmentById(binding.topContainer.id) as TopFragment).setSong(listSongs[position])
        startActivity(intent)
    }

    private fun loadData(listSong: ArrayList<Song>) {
        listSong.add(Song("Padam Padam", "Kylie Minogue", 170))
        listSong.add(Song("Umbrella", "Rihanna featuring Jay-Z", 158))
        listSong.add(Song("Toxic", "Britney Spears", 210))
        listSong.add(Song("Hits Different", "Taylor Swift", 195))
        listSong.add(Song("Rolling in the Deep", "Adele", 201))
        listSong.add(Song("Torn", "Natalie Imbruglia", 187))
        listSong.add(Song("Dance the Night", "Dua Lipa", 233))
        listSong.add(Song("Single Ladies (Put a Ring on It)", "Beyoncé", 222))
        listSong.add(Song("Rehab", "Amy Winehouse", 256))
        listSong.add(Song("Dancing on My Own", "Robyn", 149))
    }
    companion object {
        const val SONG = "key1"
    }
}