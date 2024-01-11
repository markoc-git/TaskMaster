package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import javax.persistence.Entity

@Entity(name = "tasks")

data class Task(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    @ColumnInfo(name =  "task_title")   val name:String,
    @ColumnInfo(name =  "task_description") val description:String,
    @ColumnInfo(name =  "task_date")    val dueDate:String,
    @ColumnInfo(name =  "task_status")  val status :String = "active"
)
