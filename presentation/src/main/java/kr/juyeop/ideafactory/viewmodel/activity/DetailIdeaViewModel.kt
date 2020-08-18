package kr.juyeop.ideafactory.viewmodel.activity

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import kr.juyeop.domain.model.idea.IdeaModel
import kr.juyeop.domain.usecase.DeleteUseCase
import kr.juyeop.domain.usecase.GetUseCase
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent
import java.text.SimpleDateFormat
import java.util.*

class DetailIdeaViewModel(
    private val getUseCase: GetUseCase,
    private val deleteUseCase: DeleteUseCase
) : BaseViewModel() {

    var ideaDate = MutableLiveData<String>()

    var title = MutableLiveData<String>()
    var userInfo = MutableLiveData<String>()
    var background = MutableLiveData<String>()
    var content = MutableLiveData<String>()
    var effect = MutableLiveData<String>()

    val onBackEvent = SingleLiveEvent<Unit>()
    val onDeleteEvent = SingleLiveEvent<Unit>()

    fun getIdea() {
        addDisposable(getUseCase.buildUseCaseObservable(GetUseCase.Params(ideaDate.value.toString())), object : DisposableSingleObserver<IdeaModel>(){
            override fun onSuccess(t: IdeaModel) {
                val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())

                title.value = t.title
                userInfo.value = "${t.name} | ${simpleDateFormat.format(t.date!!.toLong())}"
                background.value = t.background
                content.value = t.content
                effect.value = t.effect
            }
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }

    fun deleteIdea() {
        addDisposable(deleteUseCase.buildUseCaseObservable(DeleteUseCase.Params(ideaDate.value.toString())), object : DisposableCompletableObserver() {
            override fun onComplete() {
                onDeleteEvent.call()
            }
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }

    fun backSpace(){
        onBackEvent.call()
    }
}