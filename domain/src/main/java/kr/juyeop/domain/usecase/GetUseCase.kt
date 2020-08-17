package kr.juyeop.domain.usecase

import io.reactivex.Single
import kr.juyeop.domain.base.ParamsUseCase
import kr.juyeop.domain.model.idea.IdeaModel
import kr.juyeop.domain.repository.IdeaRepository

class GetUseCase (
    private val ideaRepository: IdeaRepository
): ParamsUseCase<GetUseCase.Params, Single<IdeaModel>>() {

    override fun buildUseCaseObservable(params: Params): Single<IdeaModel> {
        return ideaRepository.get(params.date)
    }

    data class Params (
        val date: String
    )
}