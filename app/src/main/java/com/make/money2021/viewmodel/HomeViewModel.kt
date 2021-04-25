package com.make.money2021.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.make.money2021.model.DetailsModel
import com.make.money2021.model.HomeBodyModel
import com.make.money2021.network.ApiBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class HomeViewModel(): ViewModel() {

    private val TAG = "HomeViewModel"

    private val _homeBodyList = MutableLiveData<List<HomeBodyModel>>()
    val homeBodyList: LiveData<List<HomeBodyModel>>
    get() = _homeBodyList

    init {
        fetchHomeList()
    }

    private fun fetchHomeList() {
        CompositeDisposable().add(
            ApiBuilder()
                .requestHomeBodyList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<HomeBodyModel>>() {
                    override fun onSuccess(t: List<HomeBodyModel>) {
                        _homeBodyList.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG, "onError: ${e.message}")
                        Log.d(TAG, "onError: ${e.localizedMessage}")
                        Log.d(TAG, "onError: ${e.stackTrace}")
                        Log.d(TAG, "onError: ${e.cause}")
                        Log.d(TAG, "onError: ${e.suppressed}")
                    }

                })
        )
    }



}