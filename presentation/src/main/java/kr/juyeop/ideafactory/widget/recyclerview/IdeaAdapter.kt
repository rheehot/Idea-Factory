package kr.juyeop.ideafactory.widget.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kr.juyeop.domain.model.idea.IdeaModel
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.databinding.ItemIdeaBinding
import kr.juyeop.ideafactory.databinding.ItemNoIdeaBinding

class IdeaAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var ideaList = ArrayList<IdeaModel>()
    val clickPosition = MutableLiveData<Int>()

    fun setList(list : ArrayList<IdeaModel>){
        ideaList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (ideaList[0].name.isNullOrBlank()) {
            NoItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_no_idea, parent,false))
        } else {
            ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_idea, parent,false))
        }
    }

    override fun getItemCount(): Int {
        return ideaList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.bind(ideaList[position])
            holder.itemView.setOnClickListener {
                clickPosition.value = position
            }
        }
    }

    class ItemViewHolder(private val binding : ItemIdeaBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = IdeaItemViewModel()

        fun bind(model: IdeaModel) {
            viewModel.bind(model)
            binding.viewModel = viewModel
        }
    }

    class NoItemViewHolder(private val binding: ItemNoIdeaBinding): RecyclerView.ViewHolder(binding.root)
}