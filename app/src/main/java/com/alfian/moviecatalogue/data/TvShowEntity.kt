package com.alfian.moviecatalogue.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentity")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

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

    @ColumnInfo(name = "tvFavorite")
    var tvFavorite: Boolean = false,
)