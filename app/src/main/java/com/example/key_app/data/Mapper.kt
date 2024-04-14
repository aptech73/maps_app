package com.example.key_app.data

import com.example.key_app.data.model.Data
import com.example.key_app.domain.model.CarItem
import com.example.key_app.domain.model.HeaderItem

fun Data.toCarItem() : CarItem {
    return CarItem(
        parent, type!!, title, lat!!, lon!!
    )
}

fun Data.toHeaderItem() : HeaderItem {
    return HeaderItem(
        parent, group!!, title
    )
}