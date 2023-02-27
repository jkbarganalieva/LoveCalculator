package com.geektech.lovecalculator

import com.google.gson.annotations.SerializedName

//{
//    "fname": "Jakshilik",
//    "sname": "Janara",
//    "percentage": "63",
//    "result": "All the best!"
//}

data class LoveModel (
    @SerializedName("fname")
    var firstName:String,
    @SerializedName("sname")
    var secondName:String,
    var percentage:String,
    var result:String
        )
