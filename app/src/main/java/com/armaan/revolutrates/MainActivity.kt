package com.armaan.revolutrates

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CurrenciesAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Set up the recycler
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        adapter = CurrenciesAdapter()
        recyclerView.adapter = adapter

        // Set up the view model and observers
        val viewModelFactory = MainViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(MainViewModel::class.java)




    }
}
