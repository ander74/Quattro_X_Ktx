package com.ander74.quattrox.data.daos

import androidx.room.*
import androidx.room.OnConflictStrategy
import com.ander74.quattrox.data.entities.Companero
import kotlinx.coroutines.flow.Flow

@Dao
interface CompaneroDao {

    @Query("SELECT * FROM Companeros")
    fun getAll(): List<Companero>

    @Query("SELECT * FROM Companeros WHERE id = :id")
    fun getById(id: Int): Companero

    @Update()
    fun update(companero: Companero)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(companero: Companero)

    @Delete
    fun delete(companero: Companero)
}