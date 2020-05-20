package kr.juyeop.domain.usecase

import io.reactivex.Completable
import kr.juyeop.domain.base.ParamsUseCase
import kr.juyeop.domain.model.IdeaModel
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