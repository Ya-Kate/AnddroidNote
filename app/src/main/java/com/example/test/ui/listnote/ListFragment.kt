package com.example.test.ui.listnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.model.Note
import com.example.test.note.NoteFragment.Companion.getNoteFragmentInstance
import com.example.test.singlton.SingletonNotes
import com.example.test.ui.StartFragment
import com.example.test.ui.addnote.AddNoteFragment
import com.example.test.ui.item.ItemBottomDialog
import com.example.test.ui.listnote.noteadapter.AdapterNote

class ListFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list,container,false)
    }


    fun aadNote() {
        SingletonNotes.startActivity = true
        var note = Note(
            "Понедельник",
            "Забрать проект по газу",
            "12.11.2022"
        )
        SingletonNotes.arrayNotes.add(note)
        var note2 = Note(
            "Среда",
            "Купить и забрать корм для кота",
            "10.10.2022"
        )
        SingletonNotes.arrayNotes.add(note2)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonDeleteNotes: Button = view.findViewById(R.id.delete_notes)
        buttonDeleteNotes.setOnClickListener{
            ItemBottomDialog().show(childFragmentManager, "")


        }


        val buttonLogout: Button = view.findViewById<Button>(R.id.logout_button)
        buttonLogout.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, StartFragment() )
                .commit()
        }

        if (SingletonNotes.startActivity == false) {
            aadNote()
            SingletonNotes.startActivity = true
        }

        val buttonAddNew: Button = view.findViewById(R.id.addNewNote)
        buttonAddNew.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AddNoteFragment() )
                .addToBackStack("")
                .commit()
        }

        view.findViewById<RecyclerView>(R.id.listNote).run {
            adapter = AdapterNote {
                getNoteFragmentInstance(it.title, it.message).show(childFragmentManager,"")
            }
            layoutManager = LinearLayoutManager(requireContext())
            (adapter as? AdapterNote)?.setList(SingletonNotes.arrayNotes)
        }
    }

    companion object{
        fun getListFragmentInstance(): ListFragment {
            return ListFragment()
        }
    }
}