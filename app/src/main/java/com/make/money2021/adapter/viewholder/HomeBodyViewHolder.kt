package com.make.money2021.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.make.money2021.databinding.ViewHolderHomeRecyclerBinding
import com.make.money2021.service.OnItemClickListener

class HomeBodyViewHolder(itemView: ViewHolderHomeRecyclerBinding, var itemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView.root), View.OnClickListener {

    val itemViewBinding: ViewHolderHomeRecyclerBinding = itemView

    init {
        itemView.root.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        itemClickListener.onClick(adapterPosition)
    }
}

