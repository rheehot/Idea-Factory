package kr.juyeop.ideafactory.viewmodel.fragment

import io.reactivex.observers.DisposableSingleObserver
import kr.juyeop.data.util.IdeaData
import kr.juyeop.domain.model.datalab.request.KeyGroupsModel
import kr.juyeop.domain.model.datalab.response.DataLabModel
import kr.juyeop.domain.model.idea.IdeaModel
import kr.juyeop.domain.request.DataLabRequest
import kr.juyeop.domain.usecase.DataLabUseCase
import kr.juyeop.domain.usecase.GetAllUseCase
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent
import kr.juyeop.ideafactory.widget.recyclerview.IdeaAdapter

class InventoryViewModel(
    private val getAllUseCase: GetAllUseCase,
    private val dataLabUseCase: DataLabUseCase
) : BaseViewModel() {

    val ideaList = ArrayList<IdeaModel>()
    val ideaAdapter = IdeaAdapter()

    val addIdeaEvent = SingleLiveEvent<Unit>()

    init{
        ideaAdapter.setList(ideaList)
        // getDataLab()
    }

    fun getAll() {
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

//    fun getDataLab() {
//
//        val keywords = ArrayList<String>()
//        keywords.add("엔터테인먼트")
//        keywords.add("예술")
//
//        val keyGroupsModel = KeyGroupsModel("엔터테인먼트 & 예술", keywords)
//
//        val keyGroupModelList = ArrayList<KeyGroupsModel>()
//        keyGroupModelList.add(keyGroupsModel)
//
//        val dataLabRequest = DataLabRequest("2020-07-01", "2020-07-25", "month", keyGroupModelList, "mo")
//
//        addDisposable(dataLabUseCase.buildUseCaseObservable(DataLabUseCase.Params(dataLabRequest)),
//            object : DisposableSingleObserver<DataLabModel>() {
//                override fun onSuccess(t: DataLabModel) {
//                    println(t)
//                }
//
//                override fun onError(e: Throwable) {
//                    e.printStackTrace()
//                }
//            })
//    }
}