package com.example.mobilelabas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val users = listOf(
            User("Иван Иванов"),
            User("Пётр Петров"),
            User("Сидор Сидоров"),
            User("Максим Кондратенко"),
            User("Тимур Едильбаев"),
            User("Артем Аржанов"),
            User("Владислав Кекеляев"),
            User("Ратибор Нежников"),
            User("Борис Морозов"),
            User("Динара Шукралиева"),
            User("Алексей Синельщиков"),
            User("Альберт Алиагаев"),
            User("Елена Рюмкова"),
            User("Борис Морозов"),
            User("Динара Шукралиева"),
            User("Алексей Синельщиков"),
            User("Альберт Алиагаев"),
            User("Елена Рюмкова"),
            User("Борис Морозов"),
            User("Динара Шукралиева"),
            User("Алексей Синельщиков"),
            User("Альберт Алиагаев"),
            User("Елена Рюмкова"),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.usersRecyclerView)

        val adapter = UserAdapter(users)
        recyclerView.adapter = adapter
    }
}