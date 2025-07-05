package com.example.bullxbear.portfolio.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bullxbear.R
import com.example.bullxbear.portfolio.presenter.model.UiStockState

class HoldingAdapter : ListAdapter<UiStockState, HoldingAdapter.HoldingViewHolder>(UiStockStateDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoldingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_holding, parent, false)
        return HoldingViewHolder(view)
    }

    override fun onBindViewHolder(holder: HoldingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HoldingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val symbolText: TextView = itemView.findViewById(R.id.tvSymbol)
        private val qtyText: TextView = itemView.findViewById(R.id.tvQuantity)
        private val ltpText: TextView = itemView.findViewById(R.id.tvLTP)
        private val pnlText: TextView = itemView.findViewById(R.id.tvPNL)

        fun bind(item: UiStockState) {
            symbolText.text = item.symbol
            qtyText.text = "Qty: ${item.qty}"
            ltpText.text = "LTP: ₹${item.ltp}"
            pnlText.text = "PnL: ₹${item.pnl}"
        }
    }

    class UiStockStateDiffCallback : DiffUtil.ItemCallback<UiStockState>() {
        override fun areItemsTheSame(oldItem: UiStockState, newItem: UiStockState): Boolean {
            return oldItem.symbol == newItem.symbol
        }

        override fun areContentsTheSame(oldItem: UiStockState, newItem: UiStockState): Boolean {
            return oldItem == newItem
        }
    }
}