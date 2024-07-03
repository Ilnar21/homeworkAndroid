package com.example.hw2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.databinding.ItemAlbumsBinding

class AlbumAdapter(
    private var albums: List<Album>,
    private val onClick: (Album) -> Unit
) : RecyclerView.Adapter<AlbumHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        val binding = ItemAlbumsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumHolder(binding, onClick)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.bindItem(albums[position])
    }

    fun updateDataset(newAlbums: List<Album>) {
        albums = newAlbums
        notifyDataSetChanged()
    }
}
