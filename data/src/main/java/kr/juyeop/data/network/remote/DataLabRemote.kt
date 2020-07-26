package kr.juyeop.data.network.remote

import io.reactivex.Single
import kr.juyeop.data.base.remote.BaseRemote
import kr.juyeop.data.network.service.DataLabService
import kr.juyeop.domain.model.datalab.response.DataLabModel
import kr.juyeop.domain.model.datalab.request.DataLabRequest

class DataLabRemote (
    override val service: DataLabService
) : BaseRemote<DataLabService>() {

    fun getDataLab(dataLabRequest: DataLabRequest) : Single<DataLabModel> {
        return service.getDataLab("ltzeX1sKQCW5G9QshS0G", "1bWYZENwlx", "application/json", dataLabRequest).map(getResponseData())
    }
}