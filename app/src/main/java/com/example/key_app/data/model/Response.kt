package com.example.key_app.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Response (
    val devices: Devices
)