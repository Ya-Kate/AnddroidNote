package com.example.test.ui.listnote.noteadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.ItemNoteBinding
import com.example.test.model.Note
import com.example.test.repositories.NoteRepository
import com.example.test.singlton.SingletonNotes

class AdapterNote(
    private val onClick: (note: Note) -> Unit
) : RecyclerView.Adapter<NoteViewHolder>() {
    private var list = arrayListOf<Note>()

    private val repositoryNote = NoteRepository()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        return NoteViewHolder(
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(SingletonNotes.db.noteDao().selectAllNote()[position])
        holder.itemView.setOnClickListener {
            onClick(list[position])
        }
    }

    override fun getItemCount() = repositoryNote.getListNotes().size

    fun setList(list: ArrayList<Note>) {
        this.list = list
        notifyDataSetChanged()
    }
}