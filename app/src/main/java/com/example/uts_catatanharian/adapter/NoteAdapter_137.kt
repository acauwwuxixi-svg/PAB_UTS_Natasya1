package com.example.uts_catatanharian.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_catatanharian.R
import com.example.uts_catatanharian.data.entity.NoteEntity_137

class NoteAdapter_137(
    private var noteList: List<NoteEntity_137>,
    private val onEditClick: (NoteEntity_137) -> Unit,
    private val onDeleteClick: (NoteEntity_137) -> Unit
) : RecyclerView.Adapter<NoteAdapter_137.NoteViewHolder_137>() {

    class NoteViewHolder_137(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title_137)
        val tvDate: TextView = itemView.findViewById(R.id.tv_date_137)
        val tvContent: TextView = itemView.findViewById(R.id.tv_content_snippet_137)
        val btnEdit: ImageButton = itemView.findViewById(R.id.btn_edit_137)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btn_delete_137)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder_137 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note_137, parent, false)
        return NoteViewHolder_137(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder_137, position: Int) {
        val note = noteList[position]
        holder.tvTitle.text = note.judul
        holder.tvDate.text = note.tanggal
        holder.tvContent.text = note.isi

        holder.btnEdit.setOnClickListener {
            onEditClick(note)
        }

        holder.btnDelete.setOnClickListener {
            onDeleteClick(note)
        }
    }

    override fun getItemCount(): Int = noteList.size

    fun updateNotes_137(newNotes: List<NoteEntity_137>) {
        this.noteList = newNotes
        notifyDataSetChanged()
    }
}
