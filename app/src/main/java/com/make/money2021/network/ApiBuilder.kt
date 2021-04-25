package com.make.money2021.network

import com.make.money2021.model.DetailsModel
import com.make.money2021.model.HomeBodyModel
import com.make.money2021.service.GetHomeBodyList
import com.make.money2021.service.GetDetailsBody
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiBuilder() {

    private val BASE_URL: String = "http://45.66.164.9:7568/api/"

    private val getHomeBodyList: GetHomeBodyList = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(GetHomeBodyList::class.java)

    private val getDetailsList: GetDetailsBody = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(GetDetailsBody::class.java)

    fun requestHomeBodyList(): Single<List<HomeBodyModel>> {
        return getHomeBodyList.getTopic()
    }

    fun requestDetails(): Single<List<DetailsModel>> {
        return getDetailsList.getTopic()
    }


}