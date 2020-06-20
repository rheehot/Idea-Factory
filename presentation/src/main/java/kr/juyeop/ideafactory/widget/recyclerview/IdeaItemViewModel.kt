package kr.juyeop.ideafactory.widget.recyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.juyeop.domain.model.IdeaModel

class IdeaItemViewModel : ViewModel(){
    val title = MutableLiveData<String>()
    val date = MutableLiveData<String>()

    fun bind(model : IdeaModel){
        title.value = model.title
        date.value = model.date
    }
}