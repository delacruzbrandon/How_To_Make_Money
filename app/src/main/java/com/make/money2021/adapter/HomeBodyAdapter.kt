package com.make.money2021.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.make.money2021.R
import com.make.money2021.adapter.viewholder.HomeBodyViewHolder
import com.make.money2021.databinding.ViewHolderHomeRecyclerBinding
import com.make.money2021.model.HomeBodyModel
import com.make.money2021.service.OnItemClickListener
import com.make.money2021.view.HomeFragment

class HomeBodyAdapter(var homeBodyList: List<HomeBodyModel>, var context: Context, var itemClickListener: OnItemClickListener): RecyclerView.Adapter<HomeBodyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBodyViewHolder {
        val view: ViewHolderHomeRecyclerBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_holder_home_recycler, parent, false)
        return HomeBodyViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: HomeBodyViewHolder, position: Int) {
        val homeBodyModel: HomeBodyModel = homeBodyList[position]
        holder.itemViewBinding.homeBodyModel = homeBodyModel
    }

    override fun getItemCount(): Int {
        return homeBodyList.size
    }
}