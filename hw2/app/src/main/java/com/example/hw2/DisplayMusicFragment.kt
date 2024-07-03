package com.example.hw2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.hw2.databinding.FragmentDisplayMusicBinding

class DisplayMusicFragment : Fragment(R.layout.fragment_display_music) {

    private var _binding: FragmentDisplayMusicBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDisplayMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val albumId = arguments?.getInt("albumId") ?: return
        val album = AlbumRepository.getAlbumById(albumId) ?: return

        with(binding) {
            ivAlbumCover.load(album.imageUrl)
            tvAlbumTitle.text = album.title
            tvAlbumShortDescription.text = album.artist
            tvAlbumLongDescription.text = album.detailedDescription

            ivBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
