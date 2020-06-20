package kr.juyeop.ideafactory.viewmodel.fragment

import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import kr.juyeop.domain.model.IdeaModel
import kr.juyeop.domain.usecase.GetAllUseCase
import kr.juyeop.ideafactory.base.BaseViewModel
import kr.juyeop.ideafactory.widget.recyclerview.IdeaAdapter

class InventoryViewModel(
    private val getAllUseCase: GetAllUseCase
) : BaseViewModel() {

    val ideaList = ArrayList<IdeaModel>()
    val ideaAdapter = IdeaAdapter()

    init{
        val ideaModel = IdeaModel("이름", "배경", "단디", "내용", "기대방향", "2020-06-12")
        val ideaModel2 = IdeaModel("이름", "배경", "밀수", "내용", "기대방향", "2020-06-13")
        val ideaModel3 = IdeaModel("이름", "배경", "코싸인", "내용", "기대방향", "2020-06-20")
        val ideaModel4 = IdeaModel("이름", "배경", "그리운", "내용", "기대방향", "2020-05-12")
        val ideaModel5 = IdeaModel("이름", "배경", "에브리", "내용", "기대방향", "2020-03-02")
        ideaList.add(ideaModel)
        ideaList.add(ideaModel2)
        ideaList.add(ideaModel3)
        ideaList.add(ideaModel4)
        ideaList.add(ideaModel5)

        ideaAdapter.setList(ideaList)}

    fun getAll(){
        addDisposable(getAllUseCase.buildUseCaseObservable(), object : DisposableSingleObserver<List<IdeaModel>>(){
            override fun onSuccess(t: List<IdeaModel>) {
                println("조회 성공")
                ideaList.addAll(t)
                ideaAdapter.notifyDataSetChanged()

                println(ideaList.size)
            }

            override fun onError(e: Throwable) {
                println("조회 실패")
            }
        })
    }
}