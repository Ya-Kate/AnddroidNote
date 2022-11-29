package com.example.test.ui.addnote

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.test.R
import com.example.test.databinding.FragmentAddNoteBinding
import com.example.test.model.Note
import com.example.test.sampleobserver.Publisher
import com.example.test.sampleobserver.Subscriber
import com.example.test.util.getData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : Fragment(), Subscriber {

    private val viewModel: AddNoteViewModel by viewModels()

    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Publisher.subscribe(this)

        val buttonAddnote = binding.addNote
        buttonAddnote.setOnClickListener {
            val buttonTitle = binding.title
            val buttonMessage = binding.message
            val picker: DatePicker = binding.calendarView
            val stringData: Long = getData(picker)

            val title = buttonTitle.editText?.text.toString()
            val message = buttonMessage.editText?.text.toString()

            viewModel.addNote(title, message, stringData)

//            throw RuntimeException("Test Crash")
            AlertDialog.Builder(requireContext())
                .setTitle(R.string.added_note)
                .create()
                .show()

            parentFragmentManager.beginTransaction()
                .add(R.id.container, AddNoteFragment())
                .commit()
        }
    }

    override fun updete(note: ArrayList<Note>) {

    }
}