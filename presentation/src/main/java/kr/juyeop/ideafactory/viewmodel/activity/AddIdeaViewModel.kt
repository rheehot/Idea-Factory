package kr.juyeop.ideafactory.viewmodel.activity

import android.app.Application
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.juyeop.data.sharedpreferences.SharedPreferencesManager
import kr.juyeop.domain.model.IdeaModel
import kr.juyeop.domain.usecase.InsertUseCase
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent
import java.text.SimpleDateFormat
import java.util.*

class AddIdeaViewModel(
    private val insertUsecase: InsertUseCase,
    private val application: Application
) : BaseViewModel(){

    val ideaTitle = MutableLiveData<String>()
    val ideaBackground = MutableLiveData<String>()
    val ideaContent = MutableLiveData<String>()
    val ideaExpect = MutableLiveData<String>()

    val onFailEvent = SingleLiveEvent<Unit>()
    val onCompleteEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()
    val onBackEvent = SingleLiveEvent<Unit>()

    fun submit(){
        if(checkData()){
            val simpleDateFormat = SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초")

            val user = SharedPreferencesManager.getFactoryUser(application)
            val date = simpleDateFormat.format(Date())
            val ideaModel = IdeaModel(user.toString(), ideaBackground.value.toString(), ideaTitle.value.toString(), ideaContent.value.toString(), ideaExpect.value.toString(), date.toString())

            insertIdea(ideaModel)
        } else onFailEvent.call()
    }

    fun checkData() : Boolean{
        return if(ideaTitle.value.isNullOrEmpty() || ideaBackground.value.isNullOrEmpty() || ideaContent.value.isNullOrEmpty() || ideaExpect.value.isNullOrEmpty()) false
        else ideaTitle.value?.length!! <= 15 && ideaBackground.value?.length!! <= 100 && ideaContent.value?.length!! <= 100 && ideaExpect.value?.length!! <= 100
    }

    fun insertIdea(ideaModel : IdeaModel){
        addDisposable(insertUsecase.buildUseCaseObservable(InsertUseCase.Paramas(ideaModel)), object : DisposableCompletableObserver(){
            override fun onComplete() {
                onCompleteEvent.call()
            }
            override fun onError(e: Throwable) {
                onErrorEvent.call()
            }
        })
    }

    fun backSpace(){
        onBackEvent.call()
    }
}