package com.my.pro.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.my.pro.databinding.RvItemRepositoryBinding
import com.my.pro.models.GitRepo

class RepositoryRecyclerViewAdapter(private var items: ArrayList<GitRepo>, private var listener: OnItemClickListener)
    : RecyclerView.Adapter<RepositoryRecyclerViewAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RvItemRepositoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(private var binding: RvItemRepositoryBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: GitRepo, listener: OnItemClickListener) {

//            with(binding) {
//                setVariable(BR.repoClickListener, listener)
//                setVariable(BR.repository, repo)
//            }
            binding.repository = repo
            binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition) })

            binding.executePendingBindings()
        }
    }
}