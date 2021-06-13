package com.alfian.moviecatalogue.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentity")
data class MovieEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "poster")
    var poster: Int,

    @ColumnInfo(name = "movieFavorite")
    var movieFavorite: Boolean = false,

    )
