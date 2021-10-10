package com.ander74.quattrox

import android.app.Application
import androidx.room.Room
import com.ander74.quattrox.data.databases.QuattroDb

class QuattroxApplication: Application() {

    val room = Room.databaseBuilder(
        this,
        QuattroDb::class.java,
        "QuattroX"
    ).build()
}