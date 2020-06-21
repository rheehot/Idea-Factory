package kr.juyeop.ideafactory.widget.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kr.juyeop.domain.model.IdeaModel
import kr.juyeop.ideafactory.R
import kr.juyeop.ideafactory.databinding.ItemIdeaBinding

class IdeaAdapter : RecyclerView.Adapter<IdeaAdapter.ViewHolder>(){

    var ideaList = ArrayList<IdeaModel>()
    val clickPosition = MutableLiveData<Int>()

    fun setList(list : ArrayList<IdeaModel>){
        ideaList = list
    }

    class ViewHolder(private val binding : ItemIdeaBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = IdeaItemViewModel()

        fun bind(model: IdeaModel) {
            viewModel.bind(model)
            binding.viewModel = viewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_idea, parent,false))
    }

    override fun getItemCount(): Int {
        return ideaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            bind(ideaList[position])
            itemView.setOnClickListener{
                clickPosition.value = position
            }
        }
    }
}