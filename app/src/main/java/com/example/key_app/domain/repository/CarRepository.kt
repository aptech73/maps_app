package com.example.key_app.domain.repository

import com.example.key_app.domain.model.ListItem
import io.reactivex.Observable

interface CarRepository {
    fun getListData() : Observable<List<ListItem>>
}