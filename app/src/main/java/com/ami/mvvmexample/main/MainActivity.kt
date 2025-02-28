package com.ami.mvvmexample.main

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.ami.mvvmexample.R
import com.ami.mvvmexample.api.NationService
import com.ami.mvvmexample.api.RetrofitHelper
import com.ami.mvvmexample.repository.NationRepository
import com.ami.mvvmexample.viewmodels.MainViewModel
import com.ami.mvvmexample.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainViewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nationService = RetrofitHelper.getInstance().create(NationService::class.java)

        val nationRepository = NationRepository(nationService)

        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(nationRepository)
        ).get(MainViewModel::class.java)

        mainViewModel.nations.observe(this, {
            Log.d("Amit", it.country.toString())
        })
    }
}