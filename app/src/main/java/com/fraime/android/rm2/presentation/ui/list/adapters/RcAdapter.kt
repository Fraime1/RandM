package com.fraime.android.rm2.presentation.ui.list.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fraime.android.rm2.R
import com.fraime.android.rm2.databinding.FragmentListItemBinding
import com.fraime.android.rm2.domain.model.Character
import com.fraime.android.rm2.presentation.ui.list.ListItemViewModel
import com.squareup.picasso.Picasso

class RcAdapter() : PagingDataAdapter<Character, RcAdapter.CharacterViewHolder>(CharacterDiffItemCallback){

    inner class CharacterViewHolder(private val binding: FragmentListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            Picasso.get()
                .load(character.image)
                .into(binding.iconCharacter)
            binding.viewModel?.character = character
            binding.executePendingBindings()
        }
    }

    private object CharacterDiffItemCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position= position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = DataBindingUtil.inflate<FragmentListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.fragment_list_item,
            parent,
            false
        )
        binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        binding.viewModel = ListItemViewModel(parent.findNavController())
        return CharacterViewHolder(binding)
    }
}