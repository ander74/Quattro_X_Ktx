package com.ander74.quattrox.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ander74.quattrox.data.daos.CompaneroDao
import com.ander74.quattrox.data.entities.Companero

@Database(
    entities = [Companero::class],
    version = 1
)
abstract class QuattroDb : RoomDatabase() {

    abstract fun companeroDao(): CompaneroDao

}