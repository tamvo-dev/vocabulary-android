package com.android.vocabulary.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.domain.entity.Vocabulary
import com.android.vocabulary.R

class VocabularyAdapter: RecyclerView.Adapter<VocabularyAdapter.MyViewHolder>() {

    private val vocabularys = mutableListOf<Vocabulary>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = vocabularys.size

    override fun getItemId(position: Int) = vocabularys[position].id as Long

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val vocabulary = vocabularys[position]
        holder.bindView(vocabulary)
    }

    fun addVocabularys(list: List<Vocabulary>){
        vocabularys.addAll(list)
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindView(vocabulary: Vocabulary){
            val word = itemView.findViewById<TextView>(R.id.item_word)
            val content = itemView.findViewById<TextView>(R.id.item_content)
            word.text = vocabulary.word
            content.text = vocabulary.content
        }
    }
}