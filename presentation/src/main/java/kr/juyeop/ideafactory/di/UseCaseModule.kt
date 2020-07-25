package kr.juyeop.ideafactory.di

import kr.juyeop.domain.usecase.*
import org.koin.dsl.module

val useCaseModule = module {
    single { GetAllUseCase(get()) }
    single { InsertUseCase(get()) }
    single { UpdateUseCase(get()) }
    single { DeleteUseCase(get()) }
    single { DataLabUseCase(get()) }
}