package com.make.money2021.service

import com.make.money2021.model.DetailsModel
import com.make.money2021.model.HomeBodyModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GetHomeBodyList {

    @GET("monkeymaking")
    fun getTopic(): Single<List<HomeBodyModel>>

}