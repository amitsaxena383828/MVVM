package com.ami.mvvmexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ami.mvvmexample.models.Nationalize

import com.ami.mvvmexample.repository.NationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val nationRepository: NationRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            nationRepository.getNations("nathaniel")

        }

    }

    val nations: LiveData<Nationalize>
        get() = nationRepository.nations
}