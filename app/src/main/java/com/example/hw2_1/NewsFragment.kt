package com.example.hw2_1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw2_1.databinding.FragmentNewsBinding

class NewsFragment : Fragment(R.layout.fragment_news) {
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewsBinding.bind(view)

        with(binding) {
            btnBackNews.setOnClickListener {
                findNavController().navigate(
                    R.id.action_newsFragment_to_mainFragment,
                    MainFragment.createBundle(textView.text.toString())
                )
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}