package kr.juyeop.ideafactory.di

import kr.juyeop.data.repository.IdeaRepositoryImpl
import kr.juyeop.domain.repository.IdeaRepository
import org.koin.dsl.module

val repositoryImplModule = module {
    single<IdeaRepository> { IdeaRepositoryImpl(get()) }
}