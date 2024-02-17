package com.example.actionbar.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.actionbar.R

class MainActivity : AppCompatActivity() {

    private var actionBar: ActionBar? = null
    private var isBackVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar = supportActionBar

        //Начальное состояние
        actionBar?.title = "Заголовок"
        actionBar?.subtitle = "Подзаголовок"
        actionBar?.setDisplayHomeAsUpEnabled(isBackVisible)
    }

    //Создание меню
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    //Обработка нажатий в меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.title_visibility -> {
                actionBar?.title = if (actionBar?.title?.isNotEmpty() == true) "" else "Заголовок"
                true
            }
            R.id.subtitle_visibility -> {
                actionBar?.subtitle = if (actionBar?.subtitle?.isNotEmpty() == true) "" else "Подзаголовок"
                true
            }
            R.id.navigation_visibility -> {
                isBackVisible = !isBackVisible
                actionBar?.setDisplayHomeAsUpEnabled(isBackVisible)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}