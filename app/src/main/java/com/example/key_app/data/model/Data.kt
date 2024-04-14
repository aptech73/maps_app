package com.example.key_app.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val group: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    val parent: String,
    val title: String,
    val type: String? = null
)