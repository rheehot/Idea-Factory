package kr.juyeop.ideafactory.viewmodel.fragment

import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableSingleObserver
import kr.juyeop.data.util.IdeaData
import kr.juyeop.domain.model.datalab.request.KeywordGroupsModel
import kr.juyeop.domain.model.datalab.response.DataLabModel
import kr.juyeop.domain.model.idea.IdeaModel
import kr.juyeop.domain.request.DataLabRequest
import kr.juyeop.domain.usecase.DataLabUseCase
import kr.juyeop.domain.usecase.GetAllUseCase
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.SingleLiveEvent
import kr.juyeop.ideafactory.widget.recyclerview.IdeaAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class InventoryViewModel(
    private val getAllUseCase: GetAllUseCase,
    private val dataLabUseCase: DataLabUseCase
) : BaseViewModel() {

    val firstGroup = MutableLiveData<String>()
    val secondGroup = MutableLiveData<String>()
    val thirdGroup = MutableLiveData<String>()
    val fourthGroup = MutableLiveData<String>()
    val lastUpdate = MutableLiveData<String>()

    val ideaList = ArrayList<IdeaModel>()
    val ideaAdapter = IdeaAdapter()

    val addIdeaEvent = SingleLiveEvent<Unit>()
    val dataLabEvent = SingleLiveEvent<Unit>()

    lateinit var dataLabModel : DataLabModel

    init{
        ideaAdapter.setList(ideaList)
        getDataLab()
    }

    fun getAll() {
        addDisposable(getAllUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<IdeaModel>>(){
            override fun onSuccess(t: List<IdeaModel>) {
                ideaList.addAll(t)
                ideaAdapter.notifyDataSetChanged()
            }
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })
    }
    fun addIdea(){
        addIdeaEvent.call()
    }
    fun saveIdea(){
        IdeaData.saveIdea(ideaList[ideaAdapter.clickPosition.value!!])
    }

    fun getDataLab() {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val dataLabRequest = DataLabRequest("2020-07-01", simpleDateFormat.format(Date()), "month", prepareData())

        addDisposable(dataLabUseCase.buildUseCaseObservable(DataLabUseCase.Params(dataLabRequest)),
            object : DisposableSingleObserver<DataLabModel>() {
                override fun onSuccess(t: DataLabModel) {
                    dataLabModel = t
                    dataLabEvent.call()
                }
                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
    }
    fun prepareData() : ArrayList<KeywordGroupsModel> {
        var keywords : ArrayList<String>
        var keywordGroups : KeywordGroupsModel
        val keywordGroupsList = ArrayList<KeywordGroupsModel>()

        for(i in 0..3) {
            when(i) {
                0 -> {
                    keywords = ArrayList()
                    keywords.add("엔터테인먼트")
                    keywords.add("예술")

                    keywordGroups = KeywordGroupsModel("엔터테인먼트·예술", keywords)
                    keywordGroupsList.add(keywordGroups)
                }
                1 -> {
                    keywords = ArrayList()
                    keywords.add("생활")
                    keywords.add("노하우")
                    keywords.add("쇼핑")

                    keywordGroups = KeywordGroupsModel("생활·노하우·쇼핑", keywords)
                    keywordGroupsList.add(keywordGroups)
                }
                2 -> {
                    keywords = ArrayList()
                    keywords.add("취미")
                    keywords.add("여가")
                    keywords.add("여행")

                    keywordGroups = KeywordGroupsModel("취미·여가·여행", keywords)
                    keywordGroupsList.add(keywordGroups)
                }
                3 -> {
                    keywords = ArrayList()
                    keywords.add("지식")
                    keywords.add("동향")

                    keywordGroups = KeywordGroupsModel("지식·동향", keywords)
                    keywordGroupsList.add(keywordGroups)
                }
            }
        }
        return keywordGroupsList
    }
    fun setDataLab() {
        for (i in 0..3) {
            when(i) {
                0 -> firstGroup.value = dataLabModel.results.get(i).title
                1 -> secondGroup.value = dataLabModel.results.get(i).title
                2 -> thirdGroup.value = dataLabModel.results.get(i).title
                3 -> fourthGroup.value = dataLabModel.results.get(i).title
            }
        }
        lastUpdate.value = "${dataLabModel.endDate} 동기화"
    }
}