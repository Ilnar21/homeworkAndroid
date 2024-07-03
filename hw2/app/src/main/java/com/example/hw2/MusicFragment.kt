package com.example.hw2

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw2.databinding.FragmentMusicBinding

class MusicFragment : Fragment(R.layout.fragment_music) {

    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!

    private var albumAdapter: AlbumAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMusicBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        albumAdapter = AlbumAdapter(AlbumRepository.albums) { album ->
            val bundle = bundleOf("albumId" to album.id)
            findNavController().navigate(R.id.action_musicFragment_to_displayMusicFragment, bundle)
        }

        binding.rvAlbums.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = albumAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
