package com.example.hw2_1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hw2_1.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        val text = arguments?.getString(ARG_TEXT).orEmpty()
        if (text.isNotEmpty())
            Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show()
    }

    companion object {

        private const val ARG_TEXT = "something"

        fun createBundle(text: String): Bundle {
            val bundle = Bundle()
            bundle.putString(
                ARG_TEXT,
                text
            )
            return bundle
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}