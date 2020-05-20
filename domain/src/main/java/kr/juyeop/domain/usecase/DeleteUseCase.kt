package kr.juyeop.domain.usecase

import io.reactivex.Completable
import kr.juyeop.domain.base.ParamsUseCase
import kr.juyeop.domain.repository.IdeaRepository

class DeleteUseCase(
    private val ideaRepository: IdeaRepository
) : ParamsUseCase<DeleteUseCase.Params, Completable>(){

    override fun buildUseCaseObservable(params: Params): Completable {
        return ideaRepository.delete(params.date)
    }

    data class Params(
        val date : String
    )
}