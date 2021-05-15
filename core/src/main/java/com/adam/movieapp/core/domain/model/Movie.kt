package com.adam.movieapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val tourismId: String,
    val title: String,
    val description: String,
    val poster_path: String,
    val release_date: String,
    val isFavorite: Boolean
) : Parcelable