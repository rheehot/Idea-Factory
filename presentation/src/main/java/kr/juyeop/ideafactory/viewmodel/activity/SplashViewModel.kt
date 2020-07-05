package kr.juyeop.ideafactory.viewmodel.activity

import android.content.Context
import android.content.SharedPreferences
import kr.juyeop.data.sharedpreferences.SharedPreferencesManager
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent

class SplashViewModel : BaseViewModel() {

    val onFailEvent = SingleLiveEvent<Unit>()
    val onSuccessEvent = SingleLiveEvent<Unit>()

    fun checkData(context : Context){
        if(SharedPreferencesManager.getFactoryUser(context).isNullOrEmpty()) onFailEvent.call()
        else onSuccessEvent.call()
    }
}