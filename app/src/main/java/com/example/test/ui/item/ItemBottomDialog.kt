package com.example.test.ui.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.example.test.R
import com.example.test.model.Note
import com.example.test.repositories.NoteRepository
import com.example.test.ui.listnote.ListViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ItemBottomDialog : BottomSheetDialogFragment() {

    private val noteRepository = NoteRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_button_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.yes_delete).setOnClickListener {
            noteRepository.getListNotes().clear()
            dismiss()
        }

        view.findViewById<Button>(R.id.no_delete).setOnClickListener {
            dismiss()
        }

    }
}