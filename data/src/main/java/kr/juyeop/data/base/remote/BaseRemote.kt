package kr.juyeop.data.base.remote

import io.reactivex.functions.Function
import org.json.JSONObject

abstract class BaseRemote<SV> {
    abstract val service: SV

    protected fun <T> getResponseData(): Function<retrofit2.Response<T>, T> {
        return Function { response: retrofit2.Response<T> ->
            response.body()!!
        }
    }
}