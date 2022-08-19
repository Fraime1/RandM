package com.fraime.android.rm2.presentation.ui.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.fraime.android.rm2.R
import com.fraime.android.rm2.databinding.FragmentListBinding
import com.fraime.android.rm2.presentation.extention.appComponent
import com.fraime.android.rm2.presentation.ui.MainActivity
import com.fraime.android.rm2.presentation.ui.list.adapters.CharacterLoadStateAdapter
import com.fraime.android.rm2.presentation.ui.list.adapters.RcAdapter
import javax.inject.Inject

const val TAG = "ListFragment"

class ListFragemnt : Fragment() {

    private lateinit var binding: FragmentListBinding

    @Inject
    lateinit var vmFactory: ListViewModelFactory

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this, vmFactory).get(ListViewModel::class.java)
    }
    private val adapter by lazy (LazyThreadSafetyMode.NONE){
        RcAdapter()
    }

    override fun onAttach(context: Context) {
        requireActivity().appComponent.inject(this)
        requireActivity().appComponent.inject(requireActivity() as MainActivity)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("DEBUG", "CreatedView")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        binding.recyclerView.layoutManager =LinearLayoutManager(context)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = adapter.withLoadStateFooter(CharacterLoadStateAdapter())
        adapter.addLoadStateListener { state: CombinedLoadStates ->
            binding.recyclerView.isVisible = state.refresh != LoadState.Loading
            binding.progress.isVisible = state.refresh == LoadState.Loading
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            viewModel.listCharacter
                .collect {
                    adapter.submitData(lifecycle, it)
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("DEBUG", "Destroy View")
    }
}