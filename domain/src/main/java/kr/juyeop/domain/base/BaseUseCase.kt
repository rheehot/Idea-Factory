package kr.juyeop.domain.base

abstract class BaseUseCase<out T> {
    abstract fun buildUseCaseObservable() : T
}