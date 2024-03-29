package com.example.test.ui.note

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.FragmentSearchBinding
import com.example.test.ui.listnote.ListViewModel
import com.example.test.ui.listnote.noteadapter.AdapterNote
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,

        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.search.editText?.doAfterTextChanged {
            viewModel.searchNote(it.toString())
        }

        val listSearch: RecyclerView? = null

        viewModel.searchResult.observe(viewLifecycleOwner) {
            binding.findNote.text = it.toString()
            (listSearch?.adapter as? AdapterNote)?.setList(it)
        }
        viewModel.searchResult


    }
}