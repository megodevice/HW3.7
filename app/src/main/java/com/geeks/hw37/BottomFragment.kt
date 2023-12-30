package com.geeks.hw37

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geeks.hw37.databinding.FragmentBottomBinding

class BottomFragment : Fragment() {
    private lateinit var binding: FragmentBottomBinding
    private val listSongs = ArrayList<Song>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (listSongs.isEmpty()) loadData(listSongs)
        binding.rvPlaylist.adapter = PlaylistAdapter(listSongs, this::onItemClick)
    }

    private fun loadData(listSong: ArrayList<Song>) {
        listSong.add(Song("Padam Padam", "Kylie Minogue", 170))
        listSong.add(Song("Umbrella", "Rihanna featuring Jay-Z", 158))
        listSong.add(Song("Toxic", "Britney Spears", 210))
        listSong.add(Song("Hits Different", "Taylor Swift", 195))
        listSong.add(Song("Rolling in the Deep", "Adele", 201))
        listSong.add(Song("Torn", "Natalie Imbruglia", 187))
        listSong.add(Song("Dance the Night", "Dua Lipa",233))
        listSong.add(Song("Single Ladies (Put a Ring on It)", "Beyoncé", 222))
        listSong.add(Song("Rehab", "Amy Winehouse", 256))
        listSong.add(Song("Dancing on My Own", "Robyn", 149))
    }

    private fun onItemClick (position: Int) {
        val intent = Intent(this.requireActivity(), PromotionActivity::class.java)
        intent.putExtra(SONG, listSongs[position])
        startActivity(intent)
    }

    companion object {
        const val SONG = "key1"
    }
}