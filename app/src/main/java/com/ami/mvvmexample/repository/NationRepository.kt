package com.ami.mvvmexample.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ami.mvvmexample.api.NationService
import com.ami.mvvmexample.models.Nationalize

class NationRepository(private val nationService: NationService) {

    private val nationLiveData= MutableLiveData<Nationalize>()
    val nations: LiveData<Nationalize>
    get() = nationLiveData

    suspend fun getNations(name:String){
        val result=nationService.getNations(name)

        if(result?.body()!=null){
            nationLiveData.postValue(result.body())
        }
    }
}