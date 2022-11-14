package com.example.test.ui.listnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.FragmentBottomNavigationBinding
import com.example.test.databinding.FragmentListBinding
import com.example.test.model.Note
import com.example.test.sampleobserver.Subscriber
import com.example.test.ui.note.NoteFragment.Companion.getNoteFragmentInstance
import com.example.test.singlton.SingletonNotes
import com.example.test.ui.StartFragment
import com.example.test.ui.addnote.AddNoteFragment
import com.example.test.ui.item.ItemBottomDialog
import com.example.test.ui.listnote.noteadapter.AdapterNote
import com.example.test.ui.note.BottomNavigationFragment
import com.example.test.ui.note.Profile
import com.example.test.ui.note.SearchFragment

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


    fun aadNote() {
        SingletonNotes.startActivity = true
        val note = Note(
            "Понедельник",
            "Забрать проект по газу",

            "12.11.2022"
        )
        SingletonNotes.arrayNotes.add(note)
        val note2 = Note(
            "Среда",
            "Купить и забрать корм для кота",
            "10.10.2022"
        )
        SingletonNotes.arrayNotes.add(note2)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.run {

            if (SingletonNotes.startActivity == false) {
                aadNote()
                SingletonNotes.startActivity = true
            }

            listNote = view.findViewById<RecyclerView>(R.id.listNote)
            listNote?.run {
                adapter = AdapterNote {
                    getNoteFragmentInstance(it.title, it.message).show(childFragmentManager, "")
                }
                layoutManager = LinearLayoutManager(requireContext())
//            (adapter as? AdapterNote)?.setList(viewModel.getList())
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