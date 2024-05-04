package com.example.practicaltest.Database

import androidx.lifecycle.LiveData

class ProfileRepository(private val profileDAO: DAO) {

    val readAllData: LiveData<List<Profile>> = profileDAO.readAllData();

    suspend fun Insert(profile: Profile){
        profileDAO.Insert(profile)
    }
}