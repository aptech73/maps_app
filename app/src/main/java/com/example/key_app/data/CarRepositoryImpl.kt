package com.example.key_app.data

import android.content.Context
import com.example.key_app.data.model.Response
import com.example.key_app.domain.model.ListItem
import com.example.key_app.domain.repository.CarRepository
import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable
import kotlinx.serialization.json.Json
import javax.inject.Inject

class CarRepositoryImpl (
    private val context : Context
) : CarRepository {
    override fun getListData(): Observable<List<ListItem>> {
        val items : MutableList<ListItem> = mutableListOf()
        val string =
            context.assets.open("car_list.json").bufferedReader().use {
                it.readText()
            }

        val result = Json.decodeFromString<Response>(string)

        result.devices.list.forEach {item ->
            if (item.parent == "root")
                items.add(item.toHeaderItem())
            else
                items.add(item.toCarItem())
        }

        return Observable.just(items)
    }
}