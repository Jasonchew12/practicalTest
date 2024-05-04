package com.example.practicaltest.Database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


interface DAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insert(profile: Profile)

    @Query("SELECT * FROM profile_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Profile>>

}