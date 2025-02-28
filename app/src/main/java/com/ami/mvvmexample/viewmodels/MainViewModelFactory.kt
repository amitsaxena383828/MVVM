package com.ami.mvvmexample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ami.mvvmexample.repository.NationRepository

class MainViewModelFactory(private val nationRepository: NationRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(nationRepository) as T
    }
}