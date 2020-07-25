package kr.juyeop.domain.repository

import io.reactivex.Single
import kr.juyeop.domain.model.datalab.response.DataLabModel
import kr.juyeop.domain.request.DataLabRequest

interface DataLabRepository {
    fun getDataLab(dataLabRequest : DataLabRequest) : Single<DataLabModel>
}