package kr.juyeop.data.datasource

import io.reactivex.Single
import kr.juyeop.data.base.BaseDataSource
import kr.juyeop.data.network.remote.DataLabRemote
import kr.juyeop.domain.model.datalab.response.DataLabModel
import kr.juyeop.domain.request.DataLabRequest

class DataLabDataSource (
    override val remote : DataLabRemote,
    override val cache : Any
) : BaseDataSource<DataLabRemote, Any>() {

    fun getDataLab(dataLabRequest: DataLabRequest) : Single<DataLabModel> =
        remote.getDataLab(dataLabRequest)
}