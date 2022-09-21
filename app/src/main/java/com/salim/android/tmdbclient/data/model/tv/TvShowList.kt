package com.salim.android.tmdbclient.data.model.tv


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val results: List<TvShow>,
)