package kr.juyeop.data.base.remote

import io.reactivex.functions.Function
import org.json.JSONObject

abstract class BaseRemote<SV> {
    abstract val service: SV

    protected fun <T> getResponseData(): Function<retrofit2.Response<T>, T> {
        return Function { response: retrofit2.Response<T> ->
            checkError(response)
            response.body()!!
        }
    }

    private fun checkError(response: retrofit2.Response<*>) {
        if (!response.isSuccessful) {
            val errorBody = JSONObject(response.errorBody()!!.string())
            throw Throwable(errorBody.getString("message"))
        }
    }
}