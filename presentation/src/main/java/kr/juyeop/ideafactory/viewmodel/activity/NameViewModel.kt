package kr.juyeop.ideafactory.viewmodel.activity

import android.content.Context
import androidx.lifecycle.MutableLiveData
import kr.juyeop.data.sharedpreferences.SharedPreferencesManager
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent

class NameViewModel(
    val context: Context
): BaseViewModel() {

    val userName = MutableLiveData<String>()
    val factoryName = MutableLiveData<String>()

    val onFailEvent = SingleLiveEvent<Unit>()
    val onSuccessEvent = SingleLiveEvent<Unit>()

    fun completeEvent() {
        if(checkData()) {
            SharedPreferencesManager.setFactoryUser(context, userName.value.toString())
            SharedPreferencesManager.setFactoryName(context, factoryName.value.toString())
            onSuccessEvent.call()
        } else onFailEvent.call()
    }

    fun checkData() : Boolean{
        return if(userName.value.isNullOrEmpty() || factoryName.value.isNullOrEmpty()) false
        else userName.value?.length!! <= 10 && factoryName.value?.length!! <= 15
    }
}