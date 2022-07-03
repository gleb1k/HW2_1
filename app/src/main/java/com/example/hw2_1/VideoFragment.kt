package com.example.hw2_1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw2_1.databinding.FragmentVideoBinding

class VideoFragment:Fragment(R.layout.fragment_video) {
    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentVideoBinding.bind(view)
        with(binding){
            btnBackVideos.setOnClickListener{
                findNavController().navigate(
                    R.id.action_videoFragment_to_mainFragment,
                    MainFragment.createBundle(textView.text.toString()))
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}