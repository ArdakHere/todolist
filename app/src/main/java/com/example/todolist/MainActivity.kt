package com.example.todolist


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.ui.theme.TodolistTheme
import java.text.SimpleDateFormat
import java.util.Date
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import java.sql.Types.NULL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        findViewById<Button>(R.id.buttonleft).setOnClickListener{

        }

        findViewById<Button>(R.id.buttonright).setOnClickListener{

        }*/   //  IMPLEMENT SWITCHING BETWEEN DAYS USING THESE BUTTONS

        var todoList = mutableListOf(
            ToDo("Call James", true),
            ToDo("Buy a car", false)
        )



        val dateTextView = findViewById<TextView>(R.id.date)
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val dateString = dateFormat.format(currentDate)

        dateTextView.text = dateString


        val adapter = ToDoAdapter(todoList)
        val myRecyclerView = findViewById<RecyclerView>(R.id.rvTasks)

        myRecyclerView.adapter = adapter

        myRecyclerView.layoutManager = LinearLayoutManager(this)


        findViewById<Button>(R.id.addbutton).setOnClickListener{
            var text = findViewById<EditText>(R.id.etTasks).text.toString()
            val taskToAdd = ToDo(text, false)
            todoList.add(taskToAdd)
            adapter.notifyItemInserted(todoList.size)
            text = " "
        }
    }
}

