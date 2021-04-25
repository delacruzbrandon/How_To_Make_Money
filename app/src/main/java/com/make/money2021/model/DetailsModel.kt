package com.make.money2021.model

import com.google.gson.annotations.SerializedName

class DetailsModel(
    @SerializedName("subtitle")
    var title: String,
    @SerializedName("business_type")
    var type: String,
    @SerializedName("effort")
    var effort: String,
    @SerializedName("leverage")
    var leverage: String,
    @SerializedName("descriptions")
    var body: String
)