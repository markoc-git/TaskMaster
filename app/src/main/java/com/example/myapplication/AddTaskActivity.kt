package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.google.android.material.textfield.TextInputEditText
import java.text.DateFormat
import java.util.Calendar

class AddTaskActivity : AppCompatActivity() {

    private lateinit var taskNameField: TextInputEditText
    private lateinit var taskDescriptionField: TextInputEditText
    private lateinit var taskDueDateField: TextView
    private lateinit var datePickerButton: Button
    private lateinit var toolbar: Toolbar
    private lateinit var addTask: Button
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        toolbar = findViewById(R.id.toolbarAdd)
        toolbar.title = "ADD TASK"
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        taskNameField = findViewById(R.id.task_name)
        taskDescriptionField = findViewById(R.id.task_description)
        taskDueDateField = findViewById(R.id.date_field)
        datePickerButton = findViewById(R.id.date_picker_button)
        addTask = findViewById(R.id.save_button)

       //val taskDatabase = TaskDatabase.getDatabase(applicationContext)
       // val taskDao = taskDatabase.taskDao()
        //val repository = TaskRepository(taskDao, applicationContext)

        //    taskViewModel = ViewModelProvider(this, TaskViewModelFactory(repository))
      //      .get(TaskViewModel::class.java)

        datePickerButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    calendar.set(year, month, dayOfMonth)
                    taskDueDateField.text = DateFormat.getDateInstance().format(calendar.time)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )

            datePickerDialog.datePicker.minDate = System.currentTimeMillis()
            datePickerDialog.show()
        }

        addTask.setOnClickListener {
            val name = taskNameField.text.toString()
            val description = taskDescriptionField.text.toString()
            val dueDate = taskDueDateField.text.toString()

            val task = Task(name = name, description = description, dueDate = dueDate)
            taskViewModel.insertTask(task)

            Toast.makeText(this, "Zadatak uspešno dodat!", Toast.LENGTH_SHORT).show()
        }
    }
}
