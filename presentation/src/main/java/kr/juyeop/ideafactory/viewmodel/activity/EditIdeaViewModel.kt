package kr.juyeop.ideafactory.viewmodel.activity

import android.content.Context
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import kr.juyeop.data.sharedpreferences.SharedPreferencesManager
import kr.juyeop.domain.model.idea.IdeaModel
import kr.juyeop.domain.usecase.GetUseCase
import kr.juyeop.domain.usecase.UpdateUseCase
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent

class EditIdeaViewModel(
    val context: Context,
    val getUseCase: GetUseCase,
    val updateUseCase: UpdateUseCase
) : BaseViewModel() {

    val ideaDate = MutableLiveData<String>()

    val ideaTitle = MutableLiveData<String>()
    val ideaBackground = MutableLiveData<String>()
    val ideaContent = MutableLiveData<String>()
    val ideaEffect = MutableLiveData<String>()

    val onFailEvent = SingleLiveEvent<Unit>()
    val onCompleteEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()
    val onBackEvent = SingleLiveEvent<Unit>()

    fun getIdea() {
        addDisposable(getUseCase.buildUseCaseObservable(GetUseCase.Params(ideaDate.value.toString())), object : DisposableSingleObserver<IdeaModel>() {
            override fun onSuccess(t: IdeaModel) {
                ideaTitle.value = t.title
                ideaBackground.value = t.background
                ideaContent.value = t.content
                ideaEffect.value = t.effect
            }
            override fun onError(e: Throwable) {
                onErrorEvent.call()
                e.printStackTrace()
            }
        })
    }

    fun edit() {
        if(checkData()){
            val user = SharedPreferencesManager.getFactoryUser(context)
            editIdea(user!!)
        } else onFailEvent.call()
    }
    fun checkData() : Boolean{
        return if(ideaTitle.value.isNullOrEmpty() || ideaBackground.value.isNullOrEmpty() || ideaContent.value.isNullOrEmpty() || ideaEffect.value.isNullOrEmpty()) false
        else ideaTitle.value?.length!! <= 15 && ideaBackground.value?.length!! <= 100 && ideaContent.value?.length!! <= 100 && ideaEffect.value?.length!! <= 100
    }
    fun editIdea(user: String) {
        addDisposable(updateUseCase.buildUseCaseObservable(
            UpdateUseCase.Params(user, ideaTitle.value!!, ideaBackground.value!!, ideaContent.value!!, ideaEffect.value!!, ideaDate.value!!)), object : DisposableCompletableObserver() {
            override fun onComplete() {
                onCompleteEvent.call()
            }
            override fun onError(e: Throwable) {
                onErrorEvent.call()
                e.printStackTrace()
            }
        })
    }

    fun backSpace() {
        onBackEvent.call()
    }
}