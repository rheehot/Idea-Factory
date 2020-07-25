package kr.juyeop.ideafactory.widget.recyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.juyeop.domain.model.idea.IdeaModel
import java.text.SimpleDateFormat

class IdeaItemViewModel : ViewModel(){

    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")

    val title = MutableLiveData<String>()
    val date = MutableLiveData<String>()

    fun bind(model : IdeaModel){
        title.value = model.title
        date.value = simpleDateFormat.format(model.date.toLong())
    }
}