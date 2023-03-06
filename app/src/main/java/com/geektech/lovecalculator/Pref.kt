package com.geektech.lovecalculator

import android.content.Context
import android.content.SharedPreferences

class Pref(context: Context) {

    private var preferences: SharedPreferences =
        context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    fun userSeenOnBoard() {
        preferences.edit().putBoolean("userSeen", true).apply()
    }

    fun isShown(): Boolean {
        return preferences.getBoolean("userSeen", false)
    }

}


