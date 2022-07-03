package com.example.hw2_1.thirdhw

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw2_1.R
import com.example.hw2_1.databinding.FragmentUserinfoBinding

class UserInfoFragment : Fragment(R.layout.fragment_userinfo) {
    private var _binding:FragmentUserinfoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserinfoBinding.bind(view)

        //Принимаю id от профиля и через toString выожу в textView
        val text = arguments?.getString(ARG_TEXT).orEmpty()
        if (text.isNotEmpty()) {
            binding.textView2.text = "${UserRepository.users[text.toInt()]}"

            //Кнопочка обратно
            with(binding) {
                btnBackFromUserinfo.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_userInfoFragment_to_profileFragment
                    )
                }
            }
        }

    }

    companion object {

        private const val ARG_TEXT = "id"

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