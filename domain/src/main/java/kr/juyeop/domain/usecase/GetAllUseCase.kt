package kr.juyeop.domain.usecase

import io.reactivex.Single
import kr.juyeop.domain.base.BaseUseCase
import kr.juyeop.domain.model.IdeaModel
import kr.juyeop.domain.repository.IdeaRepository

class GetAllUseCase(
    private val ideaRepository: IdeaRepository
) : BaseUseCase<Single<List<IdeaModel>>>(){

    override fun buildUseCaseObservable(): Single<List<IdeaModel>> {
        return ideaRepository.getAll()
    }
}