package com.example.hw2_1.thirdhw

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.hw2_1.databinding.ItemProfileBinding

class UserHolder(
    private val binding : ItemProfileBinding,
    private val glide: RequestManager,
    private val onItemClick: (User) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(user: User){
        with(binding){
            tvName.text= user.name
            tvLastName.text = user.lastName
            root.setOnClickListener{
                onItemClick(user)
            }

                glide
                .load(user.url)
                .into(ivCover)
        }
    }
}