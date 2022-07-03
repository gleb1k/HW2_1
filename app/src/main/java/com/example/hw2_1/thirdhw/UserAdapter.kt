package com.example.hw2_1.thirdhw

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.hw2_1.databinding.ItemProfileBinding

class UserAdapter(
    private val list:List<User>,
    private val glide: RequestManager,
    private val onItemClick: (User) -> Unit
) : RecyclerView.Adapter<UserHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserHolder = UserHolder(
        binding = ItemProfileBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onItemClick = onItemClick
    )

    override fun onBindViewHolder(
        holder: UserHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


}