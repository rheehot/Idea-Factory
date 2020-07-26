package kr.juyeop.data.repository

import io.reactivex.Single
import kr.juyeop.data.datasource.DataLabDataSource
import kr.juyeop.domain.model.datalab.response.DataLabModel
import kr.juyeop.domain.repository.DataLabRepository
import kr.juyeop.domain.model.datalab.request.DataLabRequest

class DataLabRepositoryImpl (
    private val dataLabDataSource: DataLabDataSource
) : DataLabRepository {

    override fun getDataLab(dataLabRequest: DataLabRequest): Single<DataLabModel> =
        dataLabDataSource.getDataLab(dataLabRequest)
}