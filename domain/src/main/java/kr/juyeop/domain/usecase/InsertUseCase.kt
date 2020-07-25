package kr.juyeop.domain.usecase

import io.reactivex.Completable
import io.reactivex.observers.DisposableCompletableObserver
import kr.juyeop.domain.base.ParamsUseCase
import kr.juyeop.domain.model.idea.IdeaModel
import kr.juyeop.domain.repository.IdeaRepository

class InsertUseCase(
    private val ideaRepository: IdeaRepository
) : ParamsUseCase<InsertUseCase.Paramas, Completable>() {

    override fun buildUseCaseObservable(params: Paramas): Completable {
        return ideaRepository.insert(params.ideaModel)
    }

    data class Paramas(
        val ideaModel: IdeaModel
    )
}