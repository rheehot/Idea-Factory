package kr.juyeop.domain.base

abstract class ParamsUseCase<in Params, out T>{
    abstract fun buildUseCaseObservable(params : Params) : T
}