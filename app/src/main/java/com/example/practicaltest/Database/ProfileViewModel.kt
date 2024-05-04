package com.example.practicaltest.Database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<Profile>>
    private val repository: ProfileRepository

    init{
        val profileDAO = ProfileDatabase.getDatabase(application).profileDao()
        repository = ProfileRepository(profileDAO)
        readAllData = repository.readAllData

    }

    fun Insert(profile: Profile) = viewModelScope.launch{
            repository.Insert(profile)
    }

}