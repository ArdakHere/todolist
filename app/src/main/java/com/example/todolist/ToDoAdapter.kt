package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(
    var tasks: MutableList<ToDo>) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>()
 {
    inner class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { init {
        itemView.setOnLongClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val taskToDelete = tasks[position]

                // Display a dialog or confirmation prompt for deletion
                val builder = AlertDialog.Builder(itemView.context)
                builder.setTitle("Delete Task")
                builder.setMessage("Are you sure you want to delete this task?")

                builder.setPositiveButton("Delete") { dialog, which ->
                    // Delete the task from your task list
                    tasks.removeAt(position)
                    notifyItemChanged(position)
                }

                builder.setNegativeButton("Cancel", null)

                val dialog: AlertDialog = builder.create()
                dialog.show()
            }



            true
        }
    }
    }


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