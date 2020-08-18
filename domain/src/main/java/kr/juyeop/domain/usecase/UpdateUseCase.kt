package kr.juyeop.domain.usecase

import io.reactivex.Completable
import kr.juyeop.domain.base.ParamsUseCase
import kr.juyeop.domain.repository.IdeaRepository

class UpdateUseCase(
    private val ideaRepository: IdeaRepository
) : ParamsUseCase<UpdateUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return ideaRepository.update(params.name, params.background, params.title, params.content, params.effect, params.date)
    }

    data class Params(
        val name : String,
        val title : String,
        val background : String,
        val content : String,
        val effect : String,
        val date : String
    )
}