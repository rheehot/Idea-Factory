package kr.juyeop.data.network.service

import io.reactivex.Single
import kr.juyeop.domain.model.datalab.response.DataLabModel
import kr.juyeop.domain.request.DataLabRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DataLabService {

    @POST("search")
    fun getDataLab(@Body dataLabRequest: DataLabRequest) : Single<Response<DataLabModel>>
}