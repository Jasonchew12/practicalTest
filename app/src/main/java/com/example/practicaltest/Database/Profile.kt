package com.example.practicaltest.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class Profile(
    @PrimaryKey val id: Int,

    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "Last_name") val lastName: String?
)

