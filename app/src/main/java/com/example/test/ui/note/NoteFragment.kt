package com.example.test.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import com.example.test.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val TITLE_EXTRA = "title"
private const val MESSAGE_EXTRA = "message"

class NoteFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_note,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.title).text = arguments?.getString(TITLE_EXTRA)
        view.findViewById<TextView>(R.id.message).text = arguments?.getString(MESSAGE_EXTRA)

    }

    companion object {
        fun getNoteFragmentInstance (title:String, message:String): NoteFragment {
            return NoteFragment().apply {
                arguments= bundleOf(
                    TITLE_EXTRA to title,
                    MESSAGE_EXTRA to message
                )
            }

        }
    }
}