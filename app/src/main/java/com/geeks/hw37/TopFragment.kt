package com.geeks.hw37

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geeks.hw37.databinding.FragmentTopBinding

class TopFragment(private val song: Song) : Fragment() {
    private lateinit var binding: FragmentTopBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopBinding.inflate(layoutInflater)
        return binding.root
    }

    fun setSong(song: Song) {
        binding.apply {
            tvSongName.text = song.name
            tvArtistName.text = song.artist
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSong(song)
    }
}