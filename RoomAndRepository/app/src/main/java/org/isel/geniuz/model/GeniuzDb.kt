package org.isel.geniuz.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Artist::class), version = 2)
abstract class GeniuzDb: RoomDatabase() {
    abstract fun artistDao(): ArtistDao
}