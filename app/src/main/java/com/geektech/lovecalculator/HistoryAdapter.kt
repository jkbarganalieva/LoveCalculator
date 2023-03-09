package com.geektech.lovecalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.lovecalculator.databinding.HistoryItemBinding
import com.geektech.lovecalculator.remote.LoveModel

class HistoryAdapter(): Adapter<HistoryAdapter.HistoryViewHolder>() {
    var models = arrayListOf <LoveModel>()
    fun addLoves(list: List<LoveModel>) {
        models.clear()
        models.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            HistoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int {
        return  models.size
    }
    inner class HistoryViewHolder(private val binding: HistoryItemBinding): ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel){
            with(binding){
                fnameTv.text = loveModel.firstName
                snameTv.text = loveModel.secondName
                percentageTv.text = loveModel.percentage
            }
        }
    }
}