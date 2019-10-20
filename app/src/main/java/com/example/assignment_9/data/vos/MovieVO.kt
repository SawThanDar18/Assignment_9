package com.example.assignment_9.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
 class MovieVO(

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int,

    @ColumnInfo(name = "popularity")
    @SerializedName("popularity")
    var popularity: Float,

    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    var voteCount: Int,

    @ColumnInfo(name = "video")
    @SerializedName("video")
    var video: Boolean,

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    var posterImage: String,

    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    var adult: Boolean,

    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    var backdropPath: String?,

    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    var originalLanguage: String,

    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    var originalTitle: String,

    @SerializedName("genre_ids")
    var genres: List<Int>,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String,

    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    var voteAverage: Float,

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    var overview: String,

    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    var releaseDate: String
)