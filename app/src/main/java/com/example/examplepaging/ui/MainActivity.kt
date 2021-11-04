package com.example.examplepaging.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.examplepaging.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        adapter = MovieAdapter(MovieComparator)
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        activityMainBinding.recyclerview.adapter = adapter
        viewModel.getPopMovies().observe(this){
            adapter.submitData(lifecycle, it)
        }
    }
}