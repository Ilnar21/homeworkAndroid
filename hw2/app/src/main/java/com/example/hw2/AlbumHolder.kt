package com.example.hw2

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hw2.databinding.ItemAlbumsBinding

class AlbumHolder(
    private val binding: ItemAlbumsBinding,
    private val onClick: (Album) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(album: Album) {
        with(binding) {
            albumArtistTextView.text = album.artist
            albumTitleTextView.text = album.title
            albumImageView.load(album.imageUrl)

            root.setOnClickListener {
                onClick(album)
            }
        }
    }
}
