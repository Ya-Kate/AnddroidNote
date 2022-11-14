package com.example.test.ui.listnote.noteadapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.ItemNoteBinding
import com.example.test.model.Note
import java.text.SimpleDateFormat
import java.util.*

class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(note: Note) {
        val dateString = note.nowData
        val formatter = SimpleDateFormat("dd.MM.yyyy")
        val dateNote = formatter.parse(dateString)
        val dataStringNow = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date())
        val dataNow = formatter.parse(dataStringNow)

        binding.title.text = note.title
        binding.message.text = note.message
        binding.time.text = note.nowData

        val cmp = dateNote.compareTo(dataNow)
        when {
            cmp > 0 -> {
                binding.root.setBackgroundColor(binding.root.rootView.resources.getColor(
                    R.color.item_note_today
                ))
            }
            cmp < 0 -> {
                binding.root.setBackgroundColor(binding.root.rootView.resources.getColor(
                    R.color.teal_200
                ))
            }
        }
    }

}