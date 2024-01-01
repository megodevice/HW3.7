package com.geeks.hw37

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geeks.hw37.databinding.FragmentBottomBinding

class BottomFragment(
    private val listSongs: ArrayList<Song>,
    private val onItemClick: (position: Int) -> Unit
) : Fragment() {
    private lateinit var binding: FragmentBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvPlaylist.adapter = PlaylistAdapter(listSongs, onItemClick)
    }
}