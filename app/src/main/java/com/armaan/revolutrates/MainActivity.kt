package com.armaan.revolutrates

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private final val TAG=MainActivity::class.java.simpleName

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

        viewModel.fetchRates("EUR")

        //Observer for the list
        viewModel.ratesLiveData.observe(this, Observer {
            Log.d(TAG,"Data Observed ${it.AUD} ${it.BGN} ${it.ZAR}")
        })

    }
}
