package com.example.key_app.ui.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.key_app.domain.model.ListItem
import com.example.key_app.domain.repository.CarRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SharedViewModel @Inject constructor(
    private val carRepository: CarRepository
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _listItemLiveData = MutableLiveData<List<ListItem>>(mutableListOf())
    val listItemLiveData : LiveData<List<ListItem>> = _listItemLiveData

    fun getLocalData() {
        carRepository.getListData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                { result ->
                    _listItemLiveData.value = result
                }, { error ->
                    Log.e("ViewModel", error.localizedMessage!!)
                }
            ).handleDisposable()
    }

    private fun Disposable.handleDisposable(): Disposable = apply { disposable.add(this) }
}