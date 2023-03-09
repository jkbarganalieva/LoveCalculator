package com.geektech.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.lovecalculator.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list=App.appDatabase.loveDao().getAll()
        var data=""
        list.forEach{
            data +="${it.firstName} \n  ${it.secondName} \n ${it.percentage} \n${it.result} \n "
        }
        binding.resultTV.text=data
    }
}