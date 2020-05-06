package kr.juyeop.ideafactory.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent

class NameViewModel : BaseViewModel() {

    val factoryName = MutableLiveData<String>()
    val onFailEvent = SingleLiveEvent<Unit>()
    val onSuccessEvent = SingleLiveEvent<Unit>()

    fun completeEvent(){
        if(factoryName.value.isNullOrEmpty()) onFailEvent.call()
        else onSuccessEvent.call()
    }
}