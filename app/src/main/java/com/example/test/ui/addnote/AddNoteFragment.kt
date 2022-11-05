package com.example.test.ui.addnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.model.Note
import com.example.test.singlton.SingletonNotes
import com.example.test.singlton.SingletonStringData
import com.example.test.ui.listnote.ListFragment
import com.google.android.material.textfield.TextInputLayout

class AddNoteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_note,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonBack: Button? = view.findViewById<Button>(R.id.back)
        buttonBack?.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, ListFragment())
                .addToBackStack("")
                .commit()
        }

        val buttonAddnote = view.findViewById<Button>(R.id.addNote)
        buttonAddnote?.setOnClickListener {
            val buttonTitle = view.findViewById<TextInputLayout>(R.id.title)
            val buttonMessage = view.findViewById<TextInputLayout>(R.id.message)
            val picker: DatePicker = view.findViewById<DatePicker>(R.id.calendarView)!!
            val stringData: String = SingletonStringData.getData(picker)

            val note = Note(
                buttonTitle?.editText?.text.toString(),
                buttonMessage?.editText?.text.toString(),
                stringData
            )
            SingletonNotes.arrayNotes.add(note)
            requireActivity().onBackPressed()
        }
    }
}