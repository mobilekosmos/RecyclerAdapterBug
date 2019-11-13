package com.example.recycleradapterissue

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleradapterissue.databinding.ItemViewBinding
import java.util.*

internal class RecyclerAdapterKt : RecyclerView.Adapter<BaseViewHolder>() {

    private val data = ArrayList<Item>()

    fun setData(items: List<Item>) {
        data.clear()
        data.addAll(items)
        notifyItemChanged(0)
    }

    // with data binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BaseViewHolder.BasicItemViewHolder(ItemViewBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        Log.d("+++", "onBindViewHolder pos: $position")
        val item = data[position]
        (holder as BaseViewHolder.BasicItemViewHolder).bind(item)
        holder.itemView.setPadding(0, 0, 0, 0)
    }

    // without data binding
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
//        val view = from(parent.context).inflate(R.layout.item_view, parent, false)
//        return BaseViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
//        Log.d("+++", "onBindViewHolder pos: $position")
//        val item = data[position]
//        holder.tv_title.text = item.title
//        holder.messageTextView.text = item.message
//        holder.itemView.setPadding(0, 0, 0, 0)
//    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        val item = getItem(position) as Item?
        return item?.id ?: -1 // see item.getId().
    }

    private fun getItem(position: Int): Any? {
        return if (itemCount > position) {
            data[position]
        } else {
            null
        }
    }
}

sealed class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    class BasicItemViewHolder(
        val binding: ItemViewBinding
    ) : BaseViewHolder(binding.root) {

        fun bind(item : Item) {
            binding.tvTitle.text = item.title
            binding.tvMessage.text = item.message

            // Do I really always need this?
            binding.executePendingBindings()
        }
    }
}
