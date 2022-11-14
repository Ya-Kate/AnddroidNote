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
import com.example.test.databinding.FragmentAddNoteBinding
import com.example.test.databinding.FragmentSearchBinding
import com.example.test.ui.listnote.ListViewModel

private lateinit var binding: FragmentSearchBinding

class SearchFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    val listViewModel = ListViewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.search.editText?.doAfterTextChanged {
            listViewModel.searchNote(it.toString())
        }

    }
}