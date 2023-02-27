package com.geektech.lovecalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculatePercentage(
        @Query("fname") firstName:String,
        @Query("sname") secondName:String,
        @Header("X-RapidAPI-Key") key:String="20a046466bmsh62c29a98048f2efp1f166bjsn2a453743482f",
        @Header("X-RapidAPI-Host") host:String="love-calculator.p.rapidapi.com"
    ): Call<LoveModel>

}