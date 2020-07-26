package kr.juyeop.domain.usecase

import io.reactivex.Single
import kr.juyeop.domain.base.ParamsUseCase
import kr.juyeop.domain.model.datalab.response.DataLabModel
import kr.juyeop.domain.repository.DataLabRepository
import kr.juyeop.domain.model.datalab.request.DataLabRequest

class DataLabUseCase (
    private val dataLabRepository: DataLabRepository
) : ParamsUseCase<DataLabUseCase.Params, Single<DataLabModel>>() {

    override fun buildUseCaseObservable(params: Params): Single<DataLabModel> {
        return dataLabRepository.getDataLab(params.dataLabRequest)
    }

    data class Params(
        val dataLabRequest: DataLabRequest
    )
}