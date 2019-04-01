package me.sv.exhibitions.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import me.sv.exhibitions.R
import me.sv.exhibitions.databinding.ItemExhibitBinding
import me.sv.model.Exhibit

class ExhibitsListAdapter : RecyclerView.Adapter<ExhibitsListAdapter.ExhibitViewHolder>() {
    var exhibitsList: List<Exhibit>? = null

    fun setList(exhibitsList: List<Exhibit>) {
        this.exhibitsList = exhibitsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitViewHolder {
        return ExhibitViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_exhibit, parent, false))
    }

    override fun getItemCount(): Int {
        return exhibitsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ExhibitViewHolder, position: Int) {
        val model = exhibitsList?.get(holder.adapterPosition)
        model?.let {
            holder.binding?.model = model
            it.images?.let { imagesList ->
                val slideAdapter = ImagesSlideAdapter(imagesList)
                holder.binding?.vpImages?.adapter = slideAdapter
            }
        }
    }


    class ExhibitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding: ItemExhibitBinding? = DataBindingUtil.bind(view)
            private set
    }
}