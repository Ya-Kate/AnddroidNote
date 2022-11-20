package com.example.test.ui.note

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.FragmentAddNoteBinding
import com.example.test.databinding.FragmentSearchBinding
import com.example.test.singlton.SingletonNotes
import com.example.test.ui.listnote.ListViewModel
import com.example.test.ui.listnote.noteadapter.AdapterNote

private lateinit var binding: FragmentSearchBinding

class SearchFragment: Fragment() {

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

        var listSearch: RecyclerView? = null

        viewModel.searchResult.observe(viewLifecycleOwner) {
            binding.findNote.text = it.toString()
//        (listSearch?.adapter as? AdapterNote)?.setList(it)
//    }
//        viewModel.searchResult

        }
    }
}