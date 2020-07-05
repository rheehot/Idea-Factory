package kr.juyeop.ideafactory.viewmodel.fragment

import io.reactivex.observers.DisposableSingleObserver
import kr.juyeop.data.util.IdeaData
import kr.juyeop.domain.model.IdeaModel
import kr.juyeop.domain.usecase.GetAllUseCase
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent
import kr.juyeop.ideafactory.widget.recyclerview.IdeaAdapter

class InventoryViewModel(
    private val getAllUseCase: GetAllUseCase
) : BaseViewModel() {

    val ideaList = ArrayList<IdeaModel>()
    val ideaAdapter = IdeaAdapter()
    val addIdeaEvent = SingleLiveEvent<Unit>()

    init{ ideaAdapter.setList(ideaList) }

    fun getAll(){
        addDisposable(getAllUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<IdeaModel>>(){
            override fun onSuccess(t: List<IdeaModel>) {
                ideaList.addAll(t)
                ideaAdapter.notifyDataSetChanged()
            }
            override fun onError(e: Throwable) {}
        })
    }

    fun addIdea(){
        addIdeaEvent.call()
    }

    fun saveIdea(){
        IdeaData.saveIdea(ideaList[ideaAdapter.clickPosition.value!!])
    }
}