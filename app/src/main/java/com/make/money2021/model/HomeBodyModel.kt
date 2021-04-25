package com.make.money2021.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class HomeBodyModel(
    @SerializedName("subtitle")
    var title: String,
    @SerializedName("descriptions")
    var body: String
)