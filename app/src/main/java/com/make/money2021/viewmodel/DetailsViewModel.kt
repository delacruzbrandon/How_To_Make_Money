package com.make.money2021.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.make.money2021.model.DetailsModel
import com.make.money2021.network.ApiBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DetailsViewModel(var adapterPosition: Int): ViewModel() {

    private val TAG = "DetailsViewModel"

    private val _detailsModel = MutableLiveData<DetailsModel>()
    val detailsModel: LiveData<DetailsModel>
    get() = _detailsModel


    init {
        fetchDetails()
    }

    private fun fetchDetails() {
        CompositeDisposable().add(
            ApiBuilder()
                .requestDetails()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<DetailsModel>>() {
                    override fun onSuccess(t: List<DetailsModel>) {
                        _detailsModel.value = t[adapterPosition]
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