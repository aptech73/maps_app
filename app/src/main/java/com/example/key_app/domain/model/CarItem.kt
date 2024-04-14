package com.example.key_app.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CarItem(
    val parent : String,
    val type : String,
    val title : String,
    val lat : Double,
    val lon : Double
) : ListItem, Parcelable
