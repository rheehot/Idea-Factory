package kr.juyeop.ideafactory.viewmodel.activity

import android.app.Application
import androidx.lifecycle.MutableLiveData
import kr.juyeop.data.sharedpreferences.SharedPreferencesManager
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent

class NameViewModel(
    val application: Application
): BaseViewModel() {

    val factoryUser = MutableLiveData<String>()
    val factoryName = MutableLiveData<String>()

    val onFailEvent = SingleLiveEvent<Unit>()
    val onSuccessEvent = SingleLiveEvent<Unit>()

    fun completeEvent() {
        if(checkData()) {
            SharedPreferencesManager.setFactoryUser(application, factoryUser.value.toString())
            SharedPreferencesManager.setFactoryName(application, factoryName.value.toString())
            onSuccessEvent.call()
        } else onFailEvent.call()
    }

    fun checkData() : Boolean{
        return if(factoryUser.value.isNullOrEmpty() || factoryName.value.isNullOrEmpty()) false
        else factoryUser.value?.length!! <= 10 && factoryName.value?.length!! <= 10
    }
}