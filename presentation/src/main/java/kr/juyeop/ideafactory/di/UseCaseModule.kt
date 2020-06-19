package kr.juyeop.ideafactory.di

import kr.juyeop.domain.usecase.DeleteUseCase
import kr.juyeop.domain.usecase.GetAllUseCase
import kr.juyeop.domain.usecase.InsertUseCase
import kr.juyeop.domain.usecase.UpdateUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetAllUseCase(get()) }
    single { InsertUseCase(get()) }
    single { UpdateUseCase(get()) }
    single { DeleteUseCase(get()) }
}