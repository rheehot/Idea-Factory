package kr.juyeop.ideafactory.viewmodel.activity

import androidx.lifecycle.MutableLiveData
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent

class NameViewModel : BaseViewModel() {

    val factoryUser = MutableLiveData<String>()
    val factoryName = MutableLiveData<String>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onSuccessEvent = SingleLiveEvent<Unit>()

    fun completeEvent(){
        if(checkData()) onSuccessEvent.call()
        else onFailEvent.call()
    }

    fun checkData() : Boolean{
        return if(factoryUser.value.isNullOrEmpty() || factoryName.value.isNullOrEmpty()) false
        else factoryUser.value?.length!! <= 10 && factoryName.value?.length!! <= 10
    }
}