package com.geeks.hw37

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geeks.hw37.databinding.ItemSongBinding

class PlaylistAdapter(
    private val songs: ArrayList<Song>,
    private val onItemClick: (position: Int) -> Unit
) : Adapter<ItemSongViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSongViewHolder {
        return ItemSongViewHolder(
            ItemSongBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = songs.size

    override fun onBindViewHolder(holder: ItemSongViewHolder, position: Int) {
        holder.onBind(songs[position], position)
        holder.itemView.setOnClickListener { onItemClick(position) }
    }
}

class ItemSongViewHolder(private val binding: ItemSongBinding) : ViewHolder(binding.root) {
    fun onBind(song: Song, position: Int) {
        var length = String()
        length += song.length / 60
        length += ":"
        var second = (song.length % 60).toString()
        if (second.length == 1) second = "0$second"
        length += second
        binding.apply {
            tvSongName.text = song.name
            tvArtistName.text = song.artist
            tvSongNumber.text = position.plus(1).toString()
            tvSongLength.text = length
        }
    }
}