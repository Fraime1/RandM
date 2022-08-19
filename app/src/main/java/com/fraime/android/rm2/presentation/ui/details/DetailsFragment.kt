package com.fraime.android.rm2.presentation.ui.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fraime.android.rm2.R
import com.fraime.android.rm2.databinding.FragmentDetailsBinding
import com.fraime.android.rm2.presentation.extention.appComponent
import javax.inject.Inject

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    @Inject
    lateinit var factory: DetailsViewModelFactory.Factory
    private val id by lazy {
        arguments?.getInt(ID_KEY)
    }
    private val viewModel by lazy {
        ViewModelProvider(this, factory.create(id.toString())).get(DetailsViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        requireActivity().appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    companion object {
        const val ID_KEY = "DetailsFragmentIdKey"
    }

}