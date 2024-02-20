package com.example.actionbar.main


import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.actionbar.R

class MainActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setActionBar(toolbar) // Используй setActionBar для android.widget.Toolbar

        val upArrow = resources.getDrawable(R.drawable.baseline_airline_stops_24, null)
        actionBar?.setHomeAsUpIndicator(upArrow)

        actionBar?.setDisplayHomeAsUpEnabled(true) // Показывает кнопку назад
        actionBar?.setHomeButtonEnabled(true) // Включает кнопку назад
        actionBar?.title = "Заголовок" // Устанавливает заголовок
        actionBar?.subtitle = "Tatata"

        toolbar?.inflateMenu(R.menu.menu_main)
        toolbar?.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.title_visibility -> {
                    //Обработка нажатия на пункт меню
                    true
                }
                else -> false
            }
        }

        toolbar?.setNavigationOnClickListener {
            onBackPressed() // Обрабатывает нажатие кнопки назад
        }
    }
}