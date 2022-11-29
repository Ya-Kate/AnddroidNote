package com.example.test.ui.listnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.FragmentListBinding
import com.example.test.ui.note.NoteFragment.Companion.getNoteFragmentInstance
import com.example.test.ui.listnote.noteadapter.AdapterNote
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val viewModel: ListViewModel by viewModels()

    private var listNote: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.run {
            listNote = view.findViewById(R.id.listNote)
            listNote?.run {
                adapter = AdapterNote {
                    getNoteFragmentInstance(it.title, it.message).show(childFragmentManager, "")
                }
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

        viewModel.listNotes.observe(viewLifecycleOwner) {
            (listNote?.adapter as? AdapterNote)?.setList(it)
        }
        viewModel.getList()
    }

    companion object {
        fun getListFragmentInstance(): ListFragment {
            return ListFragment()
        }
    }
}