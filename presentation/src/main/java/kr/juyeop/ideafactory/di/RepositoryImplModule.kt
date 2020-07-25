package kr.juyeop.ideafactory.di

import kr.juyeop.data.repository.DataLabRepositoryImpl
import kr.juyeop.data.repository.IdeaRepositoryImpl
import kr.juyeop.domain.repository.DataLabRepository
import kr.juyeop.domain.repository.IdeaRepository
import org.koin.dsl.module

val repositoryImplModule = module {
    single<IdeaRepository> { IdeaRepositoryImpl(get()) }
    single<DataLabRepository> { DataLabRepositoryImpl(get()) }
}