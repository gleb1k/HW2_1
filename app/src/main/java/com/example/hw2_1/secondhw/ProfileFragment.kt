package com.example.hw2_1.secondhw

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.hw2_1.R
import com.example.hw2_1.databinding.FragmentProfileBinding
import com.example.hw2_1.thirdhw.UserAdapter
import com.example.hw2_1.thirdhw.UserInfoFragment
import com.example.hw2_1.thirdhw.UserRepository
import com.google.android.material.snackbar.Snackbar

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private var adapter : UserAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)

        adapter = UserAdapter(
            UserRepository.users,
            Glide.with(this)
        ) {
            //Инфа через снекбар (не нужно)
            //Snackbar.make(binding.root, it.toString(), Snackbar.LENGTH_SHORT).show()
            findNavController().navigate(
                R.id.action_profileFragment_to_userInfoFragment,
                UserInfoFragment.createBundle(it.id.toString())
            )
        }
        binding.rvProfile.adapter = adapter


        with(binding) {
            btnBackProfile.setOnClickListener {
                findNavController().navigate(
                    R.id.action_profileFragment_to_mainFragment,
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