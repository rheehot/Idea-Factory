package kr.juyeop.ideafactory.viewmodel.activity

import io.reactivex.observers.DisposableCompletableObserver
import kr.juyeop.domain.model.IdeaModel
import kr.juyeop.domain.usecase.InsertUseCase
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent

class AddIdeaViewModel(
    private val insertUsecase : InsertUseCase
) : BaseViewModel(){

    val onCompleteEvent = SingleLiveEvent<Unit>()
    val onErrorEvent = SingleLiveEvent<Unit>()

    val ideaModel = IdeaModel("이름", "배경", "제목", "내용", "기대 효과", "날짜")

    fun insertIdea(){
        addDisposable(insertUsecase.buildUseCaseObservable(InsertUseCase.Paramas(ideaModel)), object : DisposableCompletableObserver(){
            override fun onComplete() {
                onCompleteEvent.call()
            }
            override fun onError(e: Throwable) {
                onErrorEvent.call()
            }
        })
    }
}