package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(
    var tasks: List<ToDo>) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>()
 {
    inner class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.todoitem, parent, false)

         return ToDoViewHolder(view)
     }

     override fun getItemCount(): Int {
        return tasks.size
     }

     override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {

        holder.itemView.apply {

            val tvText = findViewById<TextView>(R.id.textView)
            val isDone = findViewById<CheckBox>(R.id.checkBox)
            tvText.text = tasks[position].task
            isDone.isChecked = tasks[position].isCompleted
        }

     }
 }